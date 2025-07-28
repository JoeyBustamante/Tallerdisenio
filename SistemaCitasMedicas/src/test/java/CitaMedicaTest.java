import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    public void testSetEstadoNull() {
        CitaMedica citaPrueba = new CitaMedica(new Paciente("00000001","Pablo Naranjo","ppppp@gmail.com"), new Medico("Alberto", "cardiología"), LocalDateTime.now());
        System.out.println("setEstado(null)");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            citaPrueba.setEstado(null);
        });
        
        assertEquals("El estado no puede ser null", ex.getMessage());
    }

    @Test
    public void testSetEstadoNotNull() {
        CitaMedica citaPrueba = new CitaMedica(new Paciente("00000001","Pablo Naranjo","ppppp@gmail.com"), new Medico("Alberto", "cardiología"), LocalDateTime.now());
        System.out.println("setEstado('Cancelada')");
        citaPrueba.setEstado("Cancelada");
        assertEquals("Cancelada", citaPrueba.getEstado());
    }
    
    @Test
    public void testToString() {
        CitaMedica citaPrueba = new CitaMedica(new Paciente("00000001","Pablo Naranjo","ppppp@gmail.com"), new Medico("Alberto", "cardiología"), LocalDateTime.of(2025, Month.JULY, 28, 14, 30, 0));
        System.out.println("toString");
        String expResult = "Cita con Alberto - cardiología para Pablo Naranjo (00000001) en 2025-07-28T14:30 [Agendada]";
        assertEquals(expResult, citaPrueba.toString());
    }
    
}