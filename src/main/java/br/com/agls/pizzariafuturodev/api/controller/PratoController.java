package br.com.agls.pizzariafuturodev.api.controller;

import br.com.agls.pizzariafuturodev.model.entity.Prato;
import br.com.agls.pizzariafuturodev.model.service.interfaces.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity<Prato> salvar(@RequestBody @Valid Prato prato) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.pratoService.salvar(prato));
    }

    @GetMapping
    public ResponseEntity<List<Prato>> listar() {
        return ResponseEntity.ok(this.pratoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(this.pratoService.buscar(id));
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<Prato> buscarPorNome(@PathParam("nome") String nome) {
        return ResponseEntity.ok(this.pratoService.buscarPorNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.pratoService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
