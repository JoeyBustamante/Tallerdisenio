import java.time.LocalDateTime;

public class CitaMedica {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fechaHora;
    private String estado;

    public CitaMedica(Paciente paciente, Medico medico, LocalDateTime fechaHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.estado = "Agendada";
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Cita con " + medico + " para " + paciente + " en " + fechaHora + " [" + estado + "]";
    }
}