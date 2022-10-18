import java.sql.*;

public class Reto5 {

    private Connection conexion;
    private Statement consultas;
    private ResultSet resultado;

    public Reto5(String baseDatos) {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+baseDatos, "root", "Regedit-1");
            consultas = conexion.createStatement();
            if (conexion != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos");
        }
    }

    public void insertarProveedor(int prov_id, String prov_nombre, String prov_direccion, String prov_telefono){
        String consulta = "INSERT INTO proveedor VALUES (" + prov_id + ", '" + prov_nombre + "', '" + prov_direccion + "', '" + prov_telefono + "')";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Inserción exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar" + e.getMessage());
        }
    }

    public void insertarClientes(String alias, String nombre, String apellido, String email, String celular, int contraseña, String f_nacimiento){
        String consulta = "INSERT INTO clientes VALUES ('" + alias + "', '" + nombre + "', '" + apellido + "', '" + email + "', '" + celular + "', '" + contraseña + "', '" + f_nacimiento + "')";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Inserción exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar" + e.getMessage());
        }
    }

    public void insertarFabricantes(String fabricante){
        String consulta = "INSERT INTO fabricantes VALUES ('" + fabricante + "')";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Inserción exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar" + e.getMessage());
        }
    }

    public void insertarBicicletas(int id, String fabricante, int precio, int año){
        String consulta = "INSERT INTO bicicletas VALUES ('" + id +"  " + fabricante + "  " + precio + " " + año + "')";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Inserción exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar" + e.getMessage());
        }
    }


    public void insertarMotocicletas(int id, String fabricante, int precio, int autonomia, int id_prov){
        String consulta = "INSERT INTO compras VALUES ('" + id +"  " + fabricante + "  " + precio + " " + autonomia + " " + id_prov + "')";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Inserción exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar" + e.getMessage());
        }
    }

    public void insertarCompras(int id, String alias, String fabricante, String fecha_hora){
        String consulta = "INSERT INTO compras VALUES ('" + id +"  " + alias + "  " + fabricante + " " + fecha_hora + "')";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Inserción exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar" + e.getMessage());
        }
    }

    public void actualizacion1(int año, String fabricante){
        String consulta = "UPDATE bicicletas SET año = " + año + " WHERE fabricante = '" + fabricante + "'";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Actualización exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar" + e.getMessage());
        }
    }

    public void actualizacion2(String celular, String alias){
        String consulta = "UPDATE clientes SET celular = " + celular + " WHERE alias = '" + alias + "'";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Actualización exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar" + e.getMessage());
        }
    }

    public void eliminar(String alias, String fabricante){
        String consulta = "DELETE FROM compras WHERE alias = '" + alias + "' AND fabricante = '" + fabricante + "'";

        try {
            consultas.executeUpdate(consulta);
            if (conexion != null) {
                System.out.println("Eliminación exitosa");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar" + e.getMessage());
        }
    }






    public String consulta1(){
        String salida = "";
        String consulta1 = "SELECT fabricante FROM fabricantes ORDER BY fabricante";

        try {
            resultado = consultas.executeQuery(consulta1);
            while (resultado.next()) {
                salida += resultado.getString(1) + "\t";
            }
        } catch (Exception e) {
            System.err.println("Error al consultar" + e.getMessage());
        }

        return salida;
    }

    public String consulta2(){
        String salida = "";
        String consulta2 = "SELECT fabricante, precio, año FROM bicicletas WHERE año >=2019 ORDER BY fabricante";

        try {
            resultado = consultas.executeQuery(consulta2);
            while (resultado.next()) {
                salida += resultado.getString(1) + "\t";
                salida += resultado.getString(2) + "\t";
                salida += resultado.getString(3) + "\t\n";
            }
        } catch (Exception e) {
            System.err.println("Error al consultar" + e.getMessage());
        }

        return salida;
    }

    public String consulta3(){
        String salida = "";
        String consulta3 = "SELECT fabricante FROM motocicletas WHERE id_prov = 101";

        try {
            resultado = consultas.executeQuery(consulta3);
            while (resultado.next()) {
                salida += resultado.getString(1) + "\t\n";
            }
        } catch (Exception e) {
            System.err.println("Error al consultar" + e.getMessage());
        }

        return salida;
    }

    public String consulta4(){
        String salida = "";
        String consulta4 = "SELECT fabricante FROM compras WHERE alias = 'lucky' ORDER BY fabricante";

        try {
            resultado = consultas.executeQuery(consulta4);
            while (resultado.next()) {
                salida += resultado.getString(1) + "\t\n";
            }
        } catch (Exception e) {
            System.err.println("Error al consultar" + e.getMessage());
        }

        return salida;
    }

    public String consulta5(){
        String salida = "";
        String consulta5 = "SELECT c.alias, c.nombre, c.apellido FROM clientes c, compras p WHERE p.alias = c.alias AND p.fabricante = 'Yeti' ORDER BY nombre";

        try {
            resultado = consultas.executeQuery(consulta5);
            while (resultado.next()) {
                salida += resultado.getString(1) + "\t";
                salida += resultado.getString(2) + "\t";
                salida += resultado.getString(3) + "\t\n";
            }
        } catch (Exception e) {
            System.err.println("Error al consultar" + e.getMessage());
        }

        return salida;
    }

    public String consulta6(){
        String salida = "";
        String consulta5 = "SELECT count(fabricante) FROM bicicletas WHERE año >= 2019";

        try {
            resultado = consultas.executeQuery(consulta5);
            while (resultado.next()) {
                salida += resultado.getString(1) + "\t\n";
            }
        } catch (Exception e) {
            System.err.println("Error al consultar" + e.getMessage());
        }

        return salida;
    }






    public static void main(String[] args) {


        // Prueba de Conexion Base de Datos:
        Reto5 cbd = new Reto5("reto5");

        // Inserción de datos en la tabla proveedor:
        /*cbd.insertarProveedor(101, "Auteco","calle 7 No. 45-17", "05713224459");
        cbd.insertarProveedor(102, "Hitachi", "calle 19 No. 108-26", "05714223344");
        cbd.insertarProveedor(103, "Bosch", "carrera 68 No. 26-45", "05715678798");
        cbd.insertarProveedor(104, "Teco", "calle 77 No. 68-33", "05712213243");
        cbd.insertarProveedor(105, "General Electric", "calle 29 No. 26-12", "05717239919");*/

        // Inserción de datos en la tabla cliente:
        /*cbd.insertarClientes("lucky", "Pedro", "Perez", "lucky@mail.com", "3152503378", 26548976, "1989-04-29");
        cbd.insertarClientes("malopez", "Maria", "Lopez", "malopez@mail.com", "3112963378", 36486549, "1990-05-29");
        cbd.insertarClientes("diva", "Ana", "Diaz", "diva@mail.com", "3112503378", 36865964, "1990-04-29");
        cbd.insertarClientes("dreamer", "Luis", "Rojas", "dreamer@mail.com", "3112369378", 85679425, "1985-04-29");
        cbd.insertarClientes("ninja", "Andres", "Cruz", "ninja@mail.com", "3206982278", 96853456, "1986-06-15");
        cbd.insertarClientes("neon", "Nelson", "Ruiz", "neon@mail.com", "3132653398", 97856458, "1989-09-13");
        cbd.insertarClientes("rose", "Claudia", "Mendez", "rose@mail.com", "3256545588", 96387458, "1990-04-29");
        cbd.insertarClientes("green", "Jorge", "Rodriguez", "green@mail.com", "3653339874", 55644897, "1990-04-29");*/


        // Inserción de datos en la tabla fabricantes:
        /*cbd.insertarFabricantes("Cannondale");
        cbd.insertarFabricantes("Trek");
        cbd.insertarFabricantes("Yeti");
        cbd.insertarFabricantes("Fuji");
        cbd.insertarFabricantes("Bmc");
        cbd.insertarFabricantes("Starker");
        cbd.insertarFabricantes("Lucky Lion");
        cbd.insertarFabricantes("Be Electric");
        cbd.insertarFabricantes("Aima");
        cbd.insertarFabricantes("Mec de Colombia");
        cbd.insertarFabricantes("Atom Electric");*/


        // Inserción de datos en la tabla bicicletas:
        /*cbd.insertarBicicletas(1001, "Cannondale", 1200000, 2020);
        cbd.insertarBicicletas(1002, "Trek", 1450000, 2019);
        cbd.insertarBicicletas(1003, "Yeti", 2000000, 2020);
        cbd.insertarBicicletas(1004, "Fuji", 950000, 2021);
        cbd.insertarBicicletas(1005, "Bmc", 1950000, 1018);*/

        // Inserción de datos en la tabla motocicletas:
        /*cbd.insertarMotocicletas(2001, "Starker", 4200000, 18, 101);
        cbd.insertarMotocicletas(2002, "Lucky Lion", 5600000, 14, 102);
        cbd.insertarMotocicletas(2003, "Be Electric", 4600000, 26, 101);
        cbd.insertarMotocicletas(2004, "Aima", 8000000, 36, 103);
        cbd.insertarMotocicletas(2005, "Mec de Colombia", 5900000, 20, 104);
        cbd.insertarMotocicletas(2006, "Atom Electric", 4500000, 12, 105);*/

        // Inserción de datos en la tabla compras:
        /*cbd.insertarCompras(101,"lucky", "Cannondale", "2017-10-25 20:00:00");
        cbd.insertarCompras(102, "lucky", "Trek", "2019-03-15 18:30:00");
        cbd.insertarCompras(103, "lucky", "Starker", "2019-05-20 20:30:00");
        cbd.insertarCompras(104, "malopez", "Cannondale", "2018-05-20 20:30:00");
        cbd.insertarCompras(105, "malopez", "Starker", "2020-01-20 20:30:00");
        cbd.insertarCompras(106, "diva", "Yeti", "2019-05-20 20:30:00");
        cbd.insertarCompras(107, "diva", "Fuji", "2018-06-22 21:30:00");
        cbd.insertarCompras(108, "diva", "Lucky Lion", "2020-03-17 15:30:20");
        cbd.insertarCompras(109, "dreamer", "Lucky Lion", "2020-03-17 15:30:20");
        cbd.insertarCompras(110, "dreamer", "Be Electric", "2020-04-10 18:30:20");
        cbd.insertarCompras(111, "ninja", "Aima", "2020-02-17 20:30:20");
        cbd.insertarCompras(112, "ninja", "Starker", "2020-02-20 16:30:20");
        cbd.insertarCompras(113, "ninja", "Mec de Colombia", "2020-03-27 18:30:20");
        cbd.insertarCompras(114, "rose", "Atom Electric", "2020-03-20 21:30:20");
        cbd.insertarCompras(115, "green", "Yeti", "2020-01-10 17:30:20");
        cbd.insertarCompras(116, "green", "Trek", "2020-02-15 20:30:20");
        cbd.insertarCompras(117, "green", "Bmc", "2020-03-17 18:30:20");*/

        // Actualizacion 1  y 2 de registros:
        /*cbd.actualizacion1(2017, "Cannondale");
        cbd.actualizacion2("3115678432", "ninja");*/

        // Eliminación de registros:
        /*cbd.eliminar("green", "Trek");*/

        // Consultas:
        System.out.printf(cbd.consulta1());
        System.out.printf(cbd.consulta2());
        System.out.printf(cbd.consulta3());
        System.out.printf(cbd.consulta4());
        System.out.printf(cbd.consulta5());
        System.out.printf(cbd.consulta6());


    }

}
