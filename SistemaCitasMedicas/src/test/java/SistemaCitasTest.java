import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;

public class SistemaCitasTest {
    @Test
    public void registrarPacienteTest() {
        SistemaCitas sistema = new SistemaCitas();

        sistema.registrarPaciente("123", "María", "maria@mail.com");

        Paciente resultado = sistema.buscarPaciente("123");

        assertNotNull(resultado);
        assertEquals("María", resultado.getNombre());
        assertEquals("maria@mail.com", resultado.getCorreo());
    }


    @Test
    public void agendarCitaPacienteInexistenteTest() {
        SistemaCitas sistema = new SistemaCitas();
        sistema.registrarMedico("Dra. Contreras", "Traumatologia");

        String resultado = sistema.agendarCita("0706374386", "Traumatologia", LocalDateTime.now());

        assertEquals("Paciente no encontrado", resultado);
    }


    
    @Test
    public void solicitarExamenPacienteValidoTest() {
        SistemaCitas sistema = new SistemaCitas();
        sistema.registrarPaciente("123", "Juan", "juan@mail.com");

        String resultado = sistema.solicitarExamen("123", "Sangre");

        assertEquals("Examen solicitado exitosamente", resultado);
    }

    @Test
    public void registrarResultadoPacienteInvalidoTest() {
        SistemaCitas sistema = new SistemaCitas();

        sistema.registrarPaciente("123", "Ana", "ana@mail.com");
        sistema.solicitarExamen("123", "Orina");

        String resultado = sistema.registrarResultado("999", "Orina", "Normal");

        assertEquals("Examen no encontrado", resultado);
    }

    @Test
    public void verHistorialConYSinResultadosTest() {
        SistemaCitas sistema = new SistemaCitas();
        sistema.registrarPaciente("111", "Luz", "luz@mail.com");
        sistema.registrarPaciente("222", "Mario", "mario@mail.com");
        sistema.registrarMedico("Dra. Ana", "Pediatría");

        sistema.agendarCita("111", "Pediatría", LocalDateTime.now());
        sistema.solicitarExamen("111", "Sangre");

        String historialConDatos = sistema.verHistorial("111");
        String historialSinDatos = sistema.verHistorial("222");

        assertFalse(historialConDatos.equals("Sin historial"));
        assertEquals("Sin historial", historialSinDatos);
    }



}
