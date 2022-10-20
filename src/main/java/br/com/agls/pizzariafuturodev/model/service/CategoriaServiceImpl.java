package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;
import br.com.agls.pizzariafuturodev.model.repository.CategoriaRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {

        String nome = categoria.getNome().toLowerCase();
        validarNome(nome);
        categoria.setNome(nome);
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        Categoria categoriaPesquisada = buscar(categoria.getId());

        if(Objects.nonNull(categoria)) {// Objects.nonNull(categoria) é a mesma coisa de categoriaPesquisada != null
            BeanUtils.copyProperties(categoria, categoriaPesquisada, "id");
            validarNome(categoriaPesquisada.getNome().toLowerCase());
            this.categoriaRepository.save(categoriaPesquisada);
        }
        return null;
    }

    private void validarNome(String nome) {
        if (this.categoriaRepository.existsByNome(nome)) {
            throw new EntityExistsException("Já existe uma categoria com o nome: " + nome);
        }
    }

    @Override
    public Categoria buscar(Long id) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findById(id);

        if(categoriaPesquisada.isEmpty()) {
            throw new EntityNotFoundException("Não foi possível encontrar uma categoria com o id: " + id);
        }
        return categoriaPesquisada.get();
    }

    @Override
    public Categoria buscarPorNome(String nome) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findByNome(nome);

        if(categoriaPesquisada.isEmpty()) {
            throw new EntityNotFoundException("Não foi possível encontrar uma categoria com o nome: " + nome);
        }

        return categoriaPesquisada.get();
    }

    @Override
    public List<Categoria> listar() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        this.categoriaRepository.deleteById(id);
    }
}
