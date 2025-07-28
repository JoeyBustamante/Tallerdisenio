public class ExamenLaboratorio {
    private Paciente paciente;
    private String tipoExamen;
    private String resultado;

    public ExamenLaboratorio(Paciente paciente, String tipoExamen) {
        this.paciente = paciente;
        this.tipoExamen = tipoExamen;
        this.resultado = "Pendiente";
    }

    public void registrarResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Examen: " + tipoExamen + " - Paciente: " + paciente + " - Resultado: " + resultado;
    }
}