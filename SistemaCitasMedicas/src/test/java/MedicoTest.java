import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicoTest {

    @Test
    public void testMedicoValido() {
        Medico m = new Medico("Dr. joey", "cardiologia");
        assertEquals("Dra. Pérez", m.getNombre());
        assertEquals("Cardiología", m.getEspecialidad());
    }

    @Test
    public void testNombreVacio() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Medico("", "Pediatría");
        });
        assertEquals("Nombre no puede estar vacío", ex.getMessage());
    }
}
