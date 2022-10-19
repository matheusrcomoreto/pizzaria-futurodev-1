package br.com.agls.pizzariafuturodev.controller;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;
import br.com.agls.pizzariafuturodev.model.service.interfaces.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    //Endpoint responsável por salvar uma mesa, fazendo a chamada do service.
    @PostMapping
    public ResponseEntity<Mesa> salvar(@RequestBody Mesa mesa) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.mesaService.salvar(mesa));
    }

    @PutMapping
    public ResponseEntity<Mesa> atualizar(@RequestBody Mesa mesa) {
        return ResponseEntity.ok(this.mesaService.atualizar(mesa));
    }

    @GetMapping
    public ResponseEntity<List<Mesa>> listar() {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(this.mesaService.listar());
        return ResponseEntity.ok(this.mesaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> buscar(@PathVariable Long id) {
        Mesa mesa = this.mesaService.buscar(id);

        if(mesa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.mesaService.buscar(id));
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<Mesa>> listarAtivas() {
        return ResponseEntity.ok(this.mesaService.listarAtivas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.mesaService.excluir(id);
        return ResponseEntity.ok("Excluído com sucesso!");
    }
}
