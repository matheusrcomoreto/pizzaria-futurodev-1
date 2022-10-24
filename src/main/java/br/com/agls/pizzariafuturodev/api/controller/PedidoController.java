package br.com.agls.pizzariafuturodev.api.controller;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;
import br.com.agls.pizzariafuturodev.model.entity.Pedido;
import br.com.agls.pizzariafuturodev.model.service.interfaces.MesaService;
import br.com.agls.pizzariafuturodev.model.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.pedidoService.salvar(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(this.pedidoService.atualizar(pedido));
    }

    @PutMapping("fechar-conta/{idPedido}")
    public ResponseEntity<Pedido> fecharConta(@PathVariable Long idPedido) {
       return ResponseEntity.ok(this.pedidoService.fecharConta(idPedido));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(this.pedidoService.listar());
    }

    @GetMapping("/mesas-livres")
    public ResponseEntity<List<Mesa>> listarMesasLivres() {
        return ResponseEntity.ok(this.mesaService.listarAtivas());
    }

}
