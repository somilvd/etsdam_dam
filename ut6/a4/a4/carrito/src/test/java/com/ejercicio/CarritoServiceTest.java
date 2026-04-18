package com.ejercicio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CarritoServiceTest {

    CarritoService carritoService = new CarritoService();

    @Test
    void subtotalConVariosProductos() {
        List<Producto> carrito = List.of(
                new Producto("teclado", 30, 2),
                new Producto("raton", 10, 1) 
        );

        double resultado = CarritoService.calcularSubtotal(carrito);

        assertEquals(70, resultado);
    }

    @Test
    void subtotalConUnProducto() {
        List<Producto> carrito = List.of(
                new Producto("monitor", 100, 1)
        );

        double resultado = CarritoService.calcularSubtotal(carrito);

        assertEquals(100, resultado);
    }

    @Test
    void subtotalCarritoVacio() {
        List<Producto> carrito = List.of();

        double resultado = CarritoService.calcularSubtotal(carrito);

        assertEquals(0, resultado);
    }

    @Test
    void descuentoCero() {
        double resultado = CarritoService.aplicarDescuento(100, 0);

        assertEquals(100, resultado);
    }

    @Test
    void descuentoValido() {
        double resultado = CarritoService.aplicarDescuento(100, 10);

        assertEquals(90, resultado);
    }

    @Test
    void descuentoCienPorciento() {
        double resultado = CarritoService.aplicarDescuento(100, 100);

        assertEquals(0, resultado);
    }

    @Test
    void descuentoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarritoService.aplicarDescuento(100, -10);
        });
    }

    @Test
    void descuentoMayorQueCien() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarritoService.aplicarDescuento(100, 150);
        });
    }

    @Test
    void envioMenorQue100() {
        double resultado = CarritoService.calcularEnvio(50);

        assertEquals(5, resultado);
    }

    @Test
    void envioIgualA100() {
        double resultado = CarritoService.calcularEnvio(100);

        assertEquals(0, resultado); 
    }

    @Test
    void envioMayorQue100() {
        double resultado = CarritoService.calcularEnvio(150);

        assertEquals(0, resultado);
    }

    @Test
    void totalSinDescuento() {
        List<Producto> carrito = List.of(
                new Producto("teclado", 50, 1)
        );

        double total = CarritoService.calcularTotal(carrito, 0);

        assertEquals(55, total);
    }

    @Test
    void totalConDescuento() {
        List<Producto> carrito = List.of(
                new Producto("teclado", 100, 1)
        );

        double total = CarritoService.calcularTotal(carrito, 10);

        assertEquals(90, total);
    }

    @Test
    void totalConEnvioGratis() {
        List<Producto> carrito = List.of(
                new Producto("monitor", 120, 1)
        );

        double total = CarritoService.calcularTotal(carrito, 0);

        assertEquals(120, total);
    }
}