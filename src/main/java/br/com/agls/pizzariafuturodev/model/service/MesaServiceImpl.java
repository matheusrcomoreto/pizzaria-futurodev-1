package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;
import br.com.agls.pizzariafuturodev.model.repository.MesaRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {

    /*
    Injeção do MesaRepository utilizando o @autowired, isso substitui o new.
     */
    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public Mesa salvar(Mesa mesa) {
        Mesa mesaSalvar = this.mesaRepository.save(mesa);// Momento que chama a camada de repository
        return mesaSalvar;
    }

    @Override
    public Mesa atualizar(Mesa mesa) {
        return null;
    }

    @Override
    public Mesa buscar(Long id) {
        Optional<Mesa> mesa = this.mesaRepository.findById(id);// Momento que chama a camada de repository

        if(mesa.isPresent()) {
            return mesa.get();
        }
        return null;
    }

    @Override
    public List<Mesa> listar() {
        return this.mesaRepository.findAll();
    }// Momento que chama a camada de repository

    @Override
    public void excluir(Long id) {

    }
}
