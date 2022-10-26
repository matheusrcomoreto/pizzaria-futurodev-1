package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Cartao;
import br.com.agls.pizzariafuturodev.model.repository.CartaoRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CartaoServiceImpl implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public Cartao salvar(Cartao cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public Cartao atualizar(Cartao object) {
        return null;
    }

    @Override
    public Cartao buscar(Long id) {
        return this.cartaoRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um cartão com o id " + id);
        });
    }

    @Override
    public List<Cartao> listar() {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }
}
