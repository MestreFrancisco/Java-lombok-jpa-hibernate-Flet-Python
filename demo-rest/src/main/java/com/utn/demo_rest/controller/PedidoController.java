package com.utn.demo_rest.controller;

import com.utn.demo_rest.dto.PedidoDTO;
import com.utn.demo_rest.modelo.Pedido;
import com.utn.demo_rest.querys.MapperUtil;
import com.utn.demo_rest.service.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public List<PedidoDTO> listAll() {
        return pedidoRepository.findAll().stream()
                .map(MapperUtil::toPedidoDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getById(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(p -> ResponseEntity.ok(MapperUtil.toPedidoDTO(p)))
                .orElseGet(() -> {
                    PedidoDTO errorDto = new PedidoDTO();
                    errorDto.setError("Pedido no encontrado");
                    return ResponseEntity.status(404).body(errorDto);
                });
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido pedido) {
        Pedido saved = pedidoRepository.save(pedido);
        return ResponseEntity.ok(MapperUtil.toPedidoDTO(saved));
    }
}
