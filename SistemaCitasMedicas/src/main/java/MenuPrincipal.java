import java.util.Scanner;
import java.time.LocalDateTime;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaCitas sistema = new SistemaCitas();

        sistema.registrarMedico("Dra. Gómez", "Pediatría");
        sistema.registrarMedico("Dr. Pérez", "Medicina General");

        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Agendar cita médica");
            System.out.println("3. Solicitar examen de laboratorio");
            System.out.println("4. Registrar resultado de examen");
            System.out.println("5. Ver historial del paciente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Cédula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Correo: ");
                    String cor = sc.nextLine();
                    sistema.registrarPaciente(ced, nom, cor);
                    break;
                case 2:
                    System.out.print("Cédula del paciente: ");
                    String cedCita = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = sc.nextLine();
                    System.out.print("Fecha y hora (YYYY-MM-DD HH): ");
                    String[] partes = sc.nextLine().split(" ");
                    LocalDateTime fecha = LocalDateTime.parse(partes[0] + "T" + partes[1] + ":00");
                    sistema.agendarCita(cedCita, esp, fecha);
                    break;
                case 3:
                    System.out.print("Cédula del paciente: ");
                    String cedExam = sc.nextLine();
                    System.out.print("Tipo de examen: ");
                    String tipo = sc.nextLine();
                    sistema.solicitarExamen(cedExam, tipo);
                    break;
                case 4:
                    System.out.print("Cédula del paciente: ");
                    String cedRes = sc.nextLine();
                    System.out.print("Tipo de examen: ");
                    String tipoRes = sc.nextLine();
                    System.out.print("Resultado: ");
                    String res = sc.nextLine();
                    sistema.registrarResultado(cedRes, tipoRes, res);
                    break;
                case 5:
                    System.out.print("Cédula del paciente: ");
                    String cedHist = sc.nextLine();
                    sistema.verHistorial(cedHist);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}