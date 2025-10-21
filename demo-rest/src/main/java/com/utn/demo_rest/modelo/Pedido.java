package com.utn.demo_rest.modelo;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "pedido_productos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos;

    private LocalDate fecha;
    private Double total;

    public double sumAllProducts() {
        int total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio();
        }
        return total;
    }

    public void setProductosXCantidad(Producto producto, int cantidad) {
        ArrayList<Producto> productos_nuevos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            productos_nuevos.add(producto);
        }

        productos = productos_nuevos;
    }

    public void addProductosXCantidad(Producto producto,int cantidad)
    {

        for (int i = 0; i < cantidad; i++) {
            productos.add(producto);
        }


    }

}
