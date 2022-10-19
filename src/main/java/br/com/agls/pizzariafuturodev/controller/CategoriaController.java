package br.com.agls.pizzariafuturodev.controller;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;
import br.com.agls.pizzariafuturodev.model.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
