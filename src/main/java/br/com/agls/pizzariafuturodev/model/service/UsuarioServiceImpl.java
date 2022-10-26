package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Usuario;
import br.com.agls.pizzariafuturodev.model.repository.UsuarioRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizar(Usuario object) {
        return null;
    }

    @Override
    public Usuario buscar(Long id) {

        return this.usuarioRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

    @Override
    public List<Usuario> listar() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public void deletar(Long id) {

    }
}
