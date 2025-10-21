package com.utn.demo_rest.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private String clienteNombre;
    private List<ProductoDTO> productos;
    private String fechaPedido;
    private Double total;
    private String error;

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
