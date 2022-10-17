package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;
import br.com.agls.pizzariafuturodev.model.repository.MesaRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public Mesa salvar(Mesa mesa) {
        Mesa mesaSalvar = this.mesaRepository.save(mesa);
        return mesaSalvar;
    }

    @Override
    public Mesa atualizar(Mesa mesa) {
        return null;
    }

    @Override
    public Mesa buscar(Long id) {
        return null;
    }

    @Override
    public List<Mesa> listar() {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
