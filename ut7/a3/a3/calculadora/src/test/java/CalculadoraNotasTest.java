import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.ejercicio.CalculadoraNotas;

public class CalculadoraNotasTest {

    @Test
    void testMediaSimple() {
        assertEquals(7, CalculadoraNotas.calcularMedia(new int[] { 6, 7, 8 }));
    }

    @Test
    void testMediaDecimal() {
        assertEquals(8.5, CalculadoraNotas.calcularMedia(new int[] { 10, 9, 8, 7 }));
    }

    @Test
    void testListaVacia() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraNotas.calcularMedia(new int[] {});
        });
    }

    @Test
    void testNotaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraNotas.calcularMedia(new int[] { 5, -1, 7 });
        });
    }

    @Test
    void testNotaMayorQueDiez() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraNotas.calcularMedia(new int[] { 5, 11, 7 });
        });
    }

    @Test
    void testNotasTodasValidas() {
        assertEquals(5, CalculadoraNotas.calcularMedia(new int[] { 4, 5, 6 }));
    }

    @Test
    void testNotaMinimaValida() {
        assertEquals(0, CalculadoraNotas.calcularMedia(new int[] { 0, 0, 0 }));
    }

    @Test
    void testNotaMaximaValida() {
        assertEquals(10, CalculadoraNotas.calcularMedia(new int[] { 10, 10, 10 }));
    }

    @Test
    void testUnaSolaNota() {
        assertEquals(5, CalculadoraNotas.calcularMedia(new int[] { 5 }));
    }
}