import java.util.*;
import java.time.LocalDateTime;

public class SistemaCitas {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<CitaMedica> citas = new ArrayList<>();
    private List<ExamenLaboratorio> examenes = new ArrayList<>();

    public void registrarPaciente(String cedula, String nombre, String correo) {
        pacientes.add(new Paciente(cedula, nombre, correo));
    }

    public void registrarMedico(String nombre, String especialidad) {
        medicos.add(new Medico(nombre, especialidad));
    }

    public String agendarCita(String cedulaPaciente, String especialidad, LocalDateTime fechaHora) {
        Paciente p = buscarPaciente(cedulaPaciente);
        if (p == null) {
            return "Paciente no encontrado";
        }

        Medico m = medicos.stream()
            .filter(med -> med.getEspecialidad().equalsIgnoreCase(especialidad))
            .findFirst()
            .orElse(null);
        if (m == null) {
            return "No hay médico disponible";
        }

        citas.add(new CitaMedica(p, m, fechaHora));
        return "Cita agendada exitosamente";
    }

    public String solicitarExamen(String cedulaPaciente, String tipoExamen) {
        Paciente p = buscarPaciente(cedulaPaciente);
        if (p == null) {
            return "Paciente no encontrado";
        }

        examenes.add(new ExamenLaboratorio(p, tipoExamen));
        return "Examen solicitado exitosamente";
    }

    public String registrarResultado(String cedulaPaciente, String tipoExamen, String resultado) {
        for (ExamenLaboratorio e : examenes) {
            if (e.toString().contains(cedulaPaciente) && e.toString().contains(tipoExamen)) {
                e.registrarResultado(resultado);
                return "Resultado registrado";
            }
        }
        return "Examen no encontrado";
    }

    public String verHistorial(String cedulaPaciente) {
        StringBuilder historial = new StringBuilder();

        citas.stream()
            .filter(c -> c.getPaciente().getCedula().equals(cedulaPaciente))
            .forEach(c -> historial.append(c.toString()).append("\n"));

        examenes.stream()
            .filter(e -> e.toString().contains(cedulaPaciente))
            .forEach(e -> historial.append(e.toString()).append("\n"));

        return historial.toString().isEmpty() ? "Sin historial" : historial.toString();
    }

    public Paciente buscarPaciente(String cedula) {
        return pacientes.stream()
            .filter(p -> p.getCedula().equals(cedula))
            .findFirst().orElse(null);
    }
}
