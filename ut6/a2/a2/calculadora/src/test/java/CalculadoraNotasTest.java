import com.docencia.CalculadoraNotas;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;


public class CalculadoraNotasTest {

    @Test
    void testMediaSimple(){
        assertEquals(7, CalculadoraNotas.calcularMedia(new int[]{6,7,8}));
    }

    @Test
    void testMediaListaVacia(){
        assertEquals(new IllegalArgumentException(), CalculadoraNotas.calcularMedia(new int[]{}));
    }


}

