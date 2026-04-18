package com.ejercicio;

import java.util.List;

public class CarritoService {

    // 1. Calcular subtotal
    public static double calcularSubtotal(List<Producto> carrito) {
        double subtotal = 0;

        for (Producto p : carrito) {
            subtotal += p.getPrecio(); // ERROR intencionado
        }

        return subtotal;
    }

    // 2. Aplicar descuento
    public static double aplicarDescuento(double subtotal, double descuento) {
        return subtotal - (subtotal * descuento / 100);
    }

    // 3. Calcular envío
    public static double calcularEnvio(double subtotal) {
        if (subtotal > 100) { // ERROR intencionado
            return 0;
        } else {
            return 5;
        }
    }

    // 4. Calcular total
    public static double calcularTotal(List<Producto> carrito, double descuento) {
        double subtotal = calcularSubtotal(carrito);
        double conDescuento = aplicarDescuento(subtotal, descuento);
        double envio = calcularEnvio(subtotal); // ERROR conceptual

        return conDescuento + envio;
    }
}
