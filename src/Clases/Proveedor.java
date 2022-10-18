
package Clases;

import java.sql.*;

import Reto5.Connect;



/**
 *
 * @author camil
 */
public class Proveedor {
    private Connection conexion;

    public Proveedor(){
        conexion = Connect.getConnection();
    }

    public  ResultSet getConsulta(){

        ResultSet rs = null;

        try{

            Statement stm = (Statement) conexion.createStatement();
            rs = stm.executeQuery("SELECT * FROM proveedor");

        } catch (Exception e){

            System.out.println(e);

        }



        return rs;
    }

}

