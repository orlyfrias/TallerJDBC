import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App {
    static String url = "jdbc:mysql://localhost:3306/tallerjdbc";
    static String userName = "root";
    static String password = "";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, userName, password);
             Scanner scanner = new Scanner(System.in)) {

            PersonaServices es = new PersonaServices();
            int opcion;

            do {
                System.out.println("\n--- Menú Estudiantes ---");
                System.out.println("1. Insertar Estudiante");
                System.out.println("2. Actualizar Estudiante");
                System.out.println("3. Eliminar Estudiante");
                System.out.println("4. Consultar Todos los Estudiantes");
                System.out.println("5. Consultar Estudiante por Correo");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                
                
                while (!scanner.hasNextInt()) {
                    System.out.print("Por favor ingrese un número válido: ");
                    scanner.next();
                }
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        es.insertarEstudiante(conn, scanner);
                        break;
                    case 2:
                        es.actualizarEstudiante(conn, scanner);
                        break;
                    case 3:
                        es.eliminarEstudiante(conn, scanner);
                        break;
                    case 4:
                        es.consultarTodos(conn);
                        break;
                    case 5:
                        es.consultarPorCorreo(conn, scanner);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 6);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}