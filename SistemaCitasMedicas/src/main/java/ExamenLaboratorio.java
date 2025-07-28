public class ExamenLaboratorio {
    private Paciente paciente;
    private String tipoExamen;
    private String resultado;

    public ExamenLaboratorio(Paciente paciente, String tipoExamen) {
        this.paciente = paciente;
        this.tipoExamen = tipoExamen;
        this.resultado = "Pendiente";
    }

    // Cambiar a String para devolver mensaje
    public String registrarResultado(String resultado) {
        this.resultado = resultado;
        return "Resultado registrado correctamente";
    }

    // getter para testear el resultado
    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Examen: " + tipoExamen + " - Paciente: " + paciente + " - Resultado: " + resultado;
    }
}
