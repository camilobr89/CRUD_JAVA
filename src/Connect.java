



import java.sql.*;

/**
 *
 * @author camil
 */
public class Connect {

    private static java.sql.Connection  conexion;
    private static java.sql.Statement consultas;
    private static String mensaje;
    private  static ResultSet resultados;


    public static Connection conexion() {

        try {
            conexion= DriverManager.getConnection("jdbc:mysql://localhost/reto5", "root", "Regedit-1");
            consultas = conexion.createStatement();
            if (conexion != null) {
                mensaje= "Conexion exitosa";
                System.out.println(mensaje);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos");
        }
        return conexion;

    }
    public static void main(String[] args) {
        conexion();
    }

    // TODO code application logic here





}