package com.utn.demo_rest.querys;

import com.utn.demo_rest.modelo.Producto;
import com.utn.demo_rest.modelo.Pedido;
import com.utn.demo_rest.dto.ProductoDTO;
import com.utn.demo_rest.dto.PedidoDTO;

import java.util.stream.Collectors;

public class MapperUtil {

    public static ProductoDTO toProductoDTO(Producto producto) {
        if (producto == null) return null;
        return ProductoDTO.builder()
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .build();
    }

    public static PedidoDTO toPedidoDTO(Pedido pedido) {
        if (pedido == null) return null;
        return PedidoDTO.builder()
                .id(pedido.getId())
                .clienteNombre(pedido.getCliente() != null ? pedido.getCliente().getNombre() : null)
                .productos(pedido.getProductos() != null ? pedido.getProductos().stream()
                        .map(MapperUtil::toProductoDTO)
                        .collect(Collectors.toList()) : null)
                .total(pedido.getTotal())
                .fechaPedido(pedido.getFecha() != null ? pedido.getFecha().toString() : null)
                .build();
    }
}
