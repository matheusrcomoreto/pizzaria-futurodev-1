package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Cliente;
import br.com.agls.pizzariafuturodev.model.repository.ClienteRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        Cliente clientePesquisado = this.buscar(cliente.getId());

        BeanUtils.copyProperties(cliente, clientePesquisado, "id");

        return this.clienteRepository.save(clientePesquisado);
    }

    @Override
    public Cliente buscar(Long id) {

        return this.clienteRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um cliente com id " + id);
        });
    }

    @Override
    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }

    @Override
    public void deletar(Long id) {

    }
}
