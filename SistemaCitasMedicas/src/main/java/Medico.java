public class Medico {
    private String nombre;
    private String especialidad;

   public Medico(String nombre, String especialidad) {
    if (nombre == null || nombre.trim().isEmpty()) {
        throw new IllegalArgumentException("Nombre no puede estar vacío");
    }
    this.nombre = nombre;
    this.especialidad = especialidad;
}


    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return nombre + " - " + especialidad;
    }
}