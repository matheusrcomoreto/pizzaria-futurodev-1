package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Prato;
import br.com.agls.pizzariafuturodev.model.repository.PratoRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoServiceImpl implements PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    @Override
    public Prato salvar(Prato prato) {
        return this.pratoRepository.save(prato);
    }

    @Override
    public Prato atualizar(Prato object) {
        return null;
    }

    @Override
    public Prato buscar(Long id) {
        return null;
    }

    @Override
    public List<Prato> listar() {
        return this.pratoRepository.findAll();
    }

    @Override
    public void deletar(Long id) {

    }
}
