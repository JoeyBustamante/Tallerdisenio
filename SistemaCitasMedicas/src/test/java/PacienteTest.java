import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    public void testPacienteValido() {
        Paciente p = new Paciente("1234567890", "Juan", "juan@mail.com");
        assertEquals("1234567890", p.getCedula());
        assertEquals("Juan", p.getNombre());
        assertEquals("juan@mail.com", p.getCorreo());
    }

    @Test
    public void testCedulaVacia() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Paciente("", "Juan", "juan@mail.com");
        });
        assertEquals("Cédula no puede estar vacía", ex.getMessage());
    }
}
