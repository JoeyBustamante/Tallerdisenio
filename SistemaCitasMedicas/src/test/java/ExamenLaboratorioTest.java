import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExamenLaboratorioTest {

    @Test
    void EL1_registrarResultado_valido() {
        Paciente paciente = new Paciente("1723456789", "Juan Pérez", "juan.perez@email.com");
        ExamenLaboratorio examen = new ExamenLaboratorio(paciente, "Hemograma");
        String mensaje = examen.registrarResultado("Positivo");

        assertEquals("Resultado registrado correctamente", mensaje);
        assertEquals("Positivo", examen.getResultado());
    }

    @Test
    void EL2_toString_estadoPendiente() {
        Paciente paciente = new Paciente("1723456789", "Ana Gómez", "ana.gomez@email.com");
        ExamenLaboratorio examen = new ExamenLaboratorio(paciente, "Glucosa");
        String salida = examen.toString();

        assertTrue(salida.contains("Pendiente"), "Debe indicar que el resultado está pendiente");
    }
}
