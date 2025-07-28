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

    public void agendarCita(String cedulaPaciente, String especialidad, LocalDateTime fechaHora) {
        Paciente p = buscarPaciente(cedulaPaciente);
        if (p == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }
        Medico m = medicos.stream()
            .filter(med -> med.getEspecialidad().equalsIgnoreCase(especialidad))
            .findFirst().orElse(null);
        if (m == null) {
            System.out.println("No hay médico disponible.");
            return;
        }
        citas.add(new CitaMedica(p, m, fechaHora));
    }

    public void solicitarExamen(String cedulaPaciente, String tipoExamen) {
        Paciente p = buscarPaciente(cedulaPaciente);
        if (p != null) {
            examenes.add(new ExamenLaboratorio(p, tipoExamen));
        }
    }

    public void registrarResultado(String cedulaPaciente, String tipoExamen, String resultado) {
        for (ExamenLaboratorio e : examenes) {
            if (e.toString().contains(cedulaPaciente) && e.toString().contains(tipoExamen)) {
                e.registrarResultado(resultado);
                break;
            }
        }
    }

    public void verHistorial(String cedulaPaciente) {
        citas.stream()
            .filter(c -> c.getPaciente().getCedula().equals(cedulaPaciente))
            .forEach(System.out::println);

        examenes.stream()
            .filter(e -> e.toString().contains(cedulaPaciente))
            .forEach(System.out::println);
    }

    private Paciente buscarPaciente(String cedula) {
        return pacientes.stream()
            .filter(p -> p.getCedula().equals(cedula))
            .findFirst().orElse(null);
    }
}