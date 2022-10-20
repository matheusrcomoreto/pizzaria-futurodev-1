package br.com.agls.pizzariafuturodev.controller;

import br.com.agls.pizzariafuturodev.model.entity.Prato;
import br.com.agls.pizzariafuturodev.model.service.interfaces.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity<Prato> salvar(@RequestBody Prato prato) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.pratoService.salvar(prato));
    }

    @GetMapping
    public List<Prato> listar() {
        List<Prato> t = this.pratoService.listar();
        return t;
    }
}
