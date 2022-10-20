package br.com.agls.pizzariafuturodev.api.controller;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;
import br.com.agls.pizzariafuturodev.model.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.categoriaService.salvar(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizar(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity.ok(this.categoriaService.atualizar(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        return ResponseEntity.ok(this.categoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoriaService.buscar(id));
    }

    @GetMapping("/buscar-por-nome") //www.instagram.com?username="andre"
    public ResponseEntity<Categoria> buscarPorNome(@PathParam("nome") String nome) {
       return ResponseEntity.ok(this.categoriaService.buscarPorNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
