import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PersonaServices { 

    public void insertarEstudiante(Connection conn, Scanner in) {
        try {
            System.out.print("Nombre: ");
            String nombre = in.nextLine();
            System.out.print("Apellido: ");
            String apellido = in.nextLine();
            System.out.print("Correo (único): ");
            String correo = in.nextLine();
            System.out.print("Edad: ");
            int edad = in.nextInt();
            in.nextLine(); 
            System.out.print("Estado civil (SOLTERO, CASADO, VIUDO, UNION_LIBRE, DIVORCIADO): ");
            String estadoCivil = in.nextLine();

            String sql = "INSERT INTO Estudiantes (nombre, apellido, correo, edad, estado_civil) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, nombre);
            stm.setString(2, apellido);
            stm.setString(3, correo);
            stm.setInt(4, edad);
            stm.setString(5, estadoCivil.toUpperCase());

            int rows = stm.executeUpdate();
            System.out.println(rows > 0 ? "✅ Estudiante insertado correctamente." : "❌ Error al insertar.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al insertar: " + e.getMessage());
        }
    }

    public void actualizarEstudiante(Connection conn, Scanner in) {
        try {
            System.out.print("Correo del estudiante a actualizar: ");
            String correo = in.nextLine();
            System.out.print("Nuevo nombre: ");
            String nombre = in.nextLine();
            System.out.print("Nuevo apellido: ");
            String apellido = in.nextLine();
            System.out.print("Nueva edad: ");
            int edad = in.nextInt();
            in.nextLine(); // limpiar buffer
            System.out.print("Nuevo estado civil: ");
            String estadoCivil = in.nextLine();

            String sql = "UPDATE Estudiantes SET nombre=?, apellido=?, edad=?, estado_civil=? WHERE correo=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, nombre);
            stm.setString(2, apellido);
            stm.setInt(3, edad);
            stm.setString(4, estadoCivil.toUpperCase());
            stm.setString(5, correo);

            int rows = stm.executeUpdate();
            System.out.println(rows > 0 ? "✅ Estudiante actualizado." : "❌ No se encontró el estudiante.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminarEstudiante(Connection conn, Scanner in) {
        try {
            System.out.print("Correo del estudiante a eliminar: ");
            String correo = in.nextLine();

            String sql = "DELETE FROM Estudiantes WHERE correo=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, correo);

            int rows = stm.executeUpdate();
            System.out.println(rows > 0 ? "✅ Estudiante eliminado." : "❌ No se encontró el estudiante.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al eliminar: " + e.getMessage());
        }
    }

    public void consultarTodos(Connection conn) {
        try {
            String sql = "SELECT * FROM Estudiantes";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                System.out.printf("ID: %d | Nombre: %s %s | Correo: %s | Edad: %d | Estado Civil: %s%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getInt("edad"),
                        rs.getString("estado_civil"));
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error al consultar: " + e.getMessage());
        }
    }

    public void consultarPorCorreo(Connection conn, Scanner in) {
        try {
            System.out.print("Correo a buscar: ");
            String correo = in.nextLine();

            String sql = "SELECT * FROM Estudiantes WHERE correo=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, correo);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                System.out.printf("ID: %d | Nombre: %s %s | Correo: %s | Edad: %d | Estado Civil: %s%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getInt("edad"),
                        rs.getString("estado_civil"));
            } else {
                System.out.println("❌ Estudiante no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error al consultar: " + e.getMessage());
        }
    }
}
