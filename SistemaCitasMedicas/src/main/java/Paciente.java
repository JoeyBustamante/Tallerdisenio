public class Paciente {
    private String cedula;
    private String nombre;
    private String correo;

    public Paciente(String cedula, String nombre, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}