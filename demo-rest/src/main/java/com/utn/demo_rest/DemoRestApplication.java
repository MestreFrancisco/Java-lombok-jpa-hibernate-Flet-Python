package com.utn.demo_rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.utn.demo_rest.modelo.*;
import com.utn.demo_rest.service.*;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class DemoRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoRestApplication.class, args);
    }
    ///Bean + CommandLineRunner Sirven para crear datos iniciales , si por asi decirlo la base de datos su counrows es 0 deberia de crear estosd datos
    /// hay que usar los repo de Service pa que funquen
    @Bean
    public CommandLineRunner dataLoader(ProductoRepository productoRepo, ClienteRepository clienteRepo, PedidoRepository pedidoRepo) {
        return args -> {
            if (productoRepo.count() == 0) {
                Producto p1 = Producto.builder().nombre("Camiseta").categoria("Ropa").precio(2225.5).build();
                Producto p2 = Producto.builder().nombre("Gorra").categoria("Accesorio").precio(1512.0).build();
                Producto p3 = Producto.builder().nombre("Zapatos").categoria("Calzado").precio(15075.0).build();
                Producto p4 = Producto.builder().nombre("Nike red").categoria("Calzado").precio(200275.0).build();
                Producto p5 = Producto.builder().nombre("Nike yellow").categoria("Calzado").precio(175000.0).build();
                Producto p6 = Producto.builder().nombre("Nike Blue").categoria("Calzado").precio(245000.0).build();
                Producto p7 = Producto.builder().nombre("Nike Air Jordan").categoria("Calzado").precio(375500.0).build();
                Producto p8 = Producto.builder().nombre("Adidas one Rojas").categoria("Calzado").precio(129500.0).build();
                Producto p9 = Producto.builder().nombre("Pepsi 250ml").categoria("Bebidas").precio(1100.0).build();
                Producto p10 = Producto.builder().nombre("Empandas de Carne").categoria("Comida").precio(800.0).build();
                Producto p11 = Producto.builder().nombre("Coca cola 250ml").categoria("Bebidas").precio(1500.0).build();
                Producto p12 = Producto.builder().nombre("Alfajor Block Triple").categoria("Bebidas").precio(1500.0).build();
                Producto p13 = Producto.builder().nombre("Jugo Ceptita naranja 200ml").categoria("Bebidas").precio(1000.0).build();
                Producto p14 = Producto.builder().nombre("Cuarto Trasero X.Kg").categoria("Bebidas").precio(3000.0).build();
                Producto p15 = Producto.builder().nombre("Empanda de jamon y Queso").categoria("comida").precio(700.0).build();


                productoRepo.saveAll(Arrays.asList(
                        p1,p2,
                        p3,p4,
                        p5,p6,
                        p7,p8,
                        p9,p10,
                        p11,p12,
                        p13,p14,p15));
            }

            if (clienteRepo.count() == 0) {
                Cliente c1 = Cliente.builder().nombre("Fran Perez").email("fran@gmail.com").telefono("+54-9-261-1234-5678").build();
                //cl2
                Cliente c2 = Cliente.builder()
                        .nombre("Lucia Morales")
                        .email("lucia@yahoo.com")
                        .telefono("+54-9-261-8765-4321")
                        .build();

                //cl3
                Cliente c3 = Cliente.builder()
                        .nombre("Lucas Morales")
                        .email("lucas@yahoo.com")
                        .telefono("+54-9-261-9965-4321")
                        .build();

                //cl4
                Cliente c4 = Cliente.builder()
                        .nombre("Nicolas Mamani")
                        .email("lucas@muito.com")
                        .telefono("+54-9-261-6765-5321")
                        .build();

                //cl4
                Cliente c5 = Cliente.builder()
                        .nombre("Fernanda soza")
                        .email("soza41@microsoft.com")
                        .telefono("+54-11-666-5321")
                        .build();

                //cl4
                Cliente c6 = Cliente.builder()
                        .nombre("Sol Perez")
                        .email("solperez@telefe.ar.com")
                        .telefono("+54-11-6999-5333")
                        .build();

                //cl4
                Cliente c7 = Cliente.builder()
                        .nombre("Francisco Mestre")
                        .email("mestre642@nose.com")
                        .telefono("+54-261-307-5433")
                        .build();

                clienteRepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));

            }

            if (pedidoRepo.count() == 0) {
                Cliente c1 = clienteRepo.findAll().get(0);
                Cliente c2 = clienteRepo.findAll().get(1);
                Cliente c3 = clienteRepo.findAll().get(2);
                Cliente c4 = clienteRepo.findAll().get(3);
                Cliente c5 = clienteRepo.findAll().get(4);
                Cliente c6 = clienteRepo.findAll().get(5);
                Cliente c7 = clienteRepo.findAll().get(6);



                Producto pr1 = productoRepo.findAll().get(0);
                Producto pr2 = productoRepo.findAll().get(1);
                Producto pr3 = productoRepo.findAll().get(2);
                Producto pr4 = productoRepo.findAll().get(3);
                Producto pr5 = productoRepo.findAll().get(4);

                Producto pr6 = productoRepo.findAll().get(5);
                Producto pr7 = productoRepo.findAll().get(6);
                Producto pr8 = productoRepo.findAll().get(7);
                Producto pr9 = productoRepo.findAll().get(8);
                Producto pr10 = productoRepo.findAll().get(9);
                Producto pr11 = productoRepo.findAll().get(10);
                Producto pr12 = productoRepo.findAll().get(11);
                Producto pr13 = productoRepo.findAll().get(12);
                Producto pr14 = productoRepo.findAll().get(13);
                Producto pr15 = productoRepo.findAll().get(14);

                Pedido o1 = new Pedido();
                o1.setCliente(c1);
                o1.setFecha(LocalDate.now().minusDays(2));
                o1.setProductos(Arrays.asList(pr1, pr2));
                o1.setTotal(pr1.getPrecio() + pr2.getPrecio());

                Pedido o2 = new Pedido();
                o2.setCliente(c2);
                o2.setFecha(LocalDate.now().minusDays(1));
                o2.setProductos(Arrays.asList(pr3));
                o2.setTotal(pr3.getPrecio());

                Pedido o3 = new Pedido();
                o3.setCliente(c3);
                o3.setFecha(LocalDate.now().minusDays(4));
                o3.setProductos(Arrays.asList(pr3,pr4,pr5,pr5));
                o3.setTotal(pr3.getPrecio()+pr4.getPrecio()+ pr5.getPrecio()+ pr5.getPrecio());

                Pedido o4 = new Pedido();
                o4.setCliente(c4);
                o4.setFecha(LocalDate.now().minusDays(3));
                o4.setProductos(Arrays.asList(pr6,pr6,pr7));
                o4.setTotal(o4.sumAllProducts());

                Pedido o5 = new Pedido();
                o5.setCliente(c5);
                o5.setFecha(LocalDate.now().minusDays(3));
                o5.setProductos(Arrays.asList(pr4,pr6,pr6,pr7,pr8));
                o5.setTotal(o5.sumAllProducts());

                Pedido o6 = new Pedido();
                o6.setCliente(c6);
                o6.setFecha(LocalDate.now().minusDays(7));
                o6.setProductos(Arrays.asList(pr9,pr10,pr12,pr11,pr13,pr14,pr14,pr9,pr9));
                o6.setTotal(o6.sumAllProducts());

                Pedido o7 = new Pedido();
                o7.setCliente(c7);
                o7.setFecha(LocalDate.now().minusDays(8));
                o7.setProductosXCantidad(pr10,12);
                o7.setTotal(o7.sumAllProducts());

                Pedido o8 = new Pedido();
                o8.setCliente(c7);
                o8.setFecha(LocalDate.now().minusDays(18));
                o8.setProductosXCantidad(pr10,6);
                o8.addProductosXCantidad(pr15,6);
                o8.setTotal(o8.sumAllProducts());

                pedidoRepo.save(o1);
                pedidoRepo.save(o2);
                pedidoRepo.save(o3);
                pedidoRepo.save(o4);
                pedidoRepo.save(o5);
                pedidoRepo.save(o6);
                pedidoRepo.save(o7);
                pedidoRepo.save(o8);

            }
        };
    }
}
