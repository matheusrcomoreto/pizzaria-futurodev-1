package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.*;
import br.com.agls.pizzariafuturodev.model.exception.FalhaNoPagamentoException;
import br.com.agls.pizzariafuturodev.model.exception.SaldoInsuficienteException;
import br.com.agls.pizzariafuturodev.model.repository.PedidoRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.CartaoService;
import br.com.agls.pizzariafuturodev.model.service.interfaces.MesaService;
import br.com.agls.pizzariafuturodev.model.service.interfaces.PedidoService;
import br.com.agls.pizzariafuturodev.model.service.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public Pedido salvar(Pedido pedido) {
        Cliente clientePesquisado = this.clienteService.buscar(pedido.getCliente().getId());
        pedido.setCliente(clientePesquisado);

        Pedido pedidoSalvo = this.pedidoRepository.save(pedido);

        if(pedidoSalvo.getId() != null) {
            Mesa mesaReservada = this.mesaService.buscar(pedidoSalvo.getMesa().getId());
            mesaReservada.setStatus(false);
            this.mesaService.atualizar(mesaReservada);
        }

        return pedidoSalvo;
    }

    @Override
    public Pedido atualizar(Pedido pedido) {
        Pedido pedidoPesquisado = buscar(pedido.getId());
        //BeanUtils.copyProperties(pedido, pedidoPesquisado, "id");
        pedidoPesquisado.setPedidoPrato(pedido.getPedidoPrato());

        return this.pedidoRepository.save(pedido);
    }

    @Override
    public Pedido buscar(Long id) {
        return this.pedidoRepository
            .findById(id)
                .orElseThrow(() -> {
                throw new EntityNotFoundException("Não foi possível encontrar um pedido com id: " + id);
            }
        );
    }

    @Override
    public List<Pedido> listar() {
        return this.pedidoRepository.findAll();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public Pedido fecharConta(Long idPedido, String numeroCartao) {
        Pedido pedidoFechado = null;
        Pedido pedidoPesquisado = buscar(idPedido);
        Double valorConta = calcularValorConta(pedidoPesquisado.getPedidoPrato());
        pedidoPesquisado.setValorTotal(valorConta);

        //TODO Implementar pagamento.
        fazerPagamento(pedidoPesquisado, numeroCartao);

        try {
            pedidoFechado = this.pedidoRepository.save(pedidoPesquisado);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        atualizarMesa(pedidoPesquisado.getMesa());
        return pedidoFechado;
    }

    private void fazerPagamento(Pedido pedido, String numeroCartao) {
        Double valorConta = pedido.getValorTotal();
        Cartao cartaoSelecionado = this.cartaoService.buscarPeloNumeroCartaoCliente(numeroCartao,pedido.getCliente().getId());

        //TODO corrigir gambiarra
        cartaoSelecionado.setSaldo(cartaoSelecionado.getLimite());

        if(cartaoSelecionado.getSaldo() >= valorConta) {
            try {
                cartaoSelecionado.setLimiteUtilizado(cartaoSelecionado.getLimiteUtilizado() + valorConta);
                cartaoSelecionado.setSaldo(cartaoSelecionado.getLimite() - cartaoSelecionado.getLimiteUtilizado());
                this.cartaoService.atualizar(cartaoSelecionado);
                pedido.setIsPago(true);
            } catch (Exception e) {
                throw new FalhaNoPagamentoException();
            }
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    private Double calcularValorConta(List<Prato> pratosPedidos) {
        Double total = 0.0;

        if(pratosPedidos != null || !pratosPedidos.isEmpty()) {
            for (Prato prato: pratosPedidos) {
                total += prato.getValor();
            }
        }
        return total;
    }

    private void atualizarMesa(Mesa mesa) {
        Mesa mesaPesquisada = this.mesaService.buscar(mesa.getId());
        mesaPesquisada.setStatus(true);
        this.mesaService.atualizar(mesaPesquisada);
    }
}
