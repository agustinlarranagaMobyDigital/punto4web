package com.example.punto_4_web.DAO;

import com.example.punto_4_web.Models.Producto;

import java.sql.*;
import java.util.ArrayList;

public class ProductoDAO implements Irepository{

    public static void add(Producto producto) throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        PreparedStatement statement = instancia.prepareStatement("INSERT INTO productos(nombre,marca,stock,precio) " +
                "VALUES(?,?,?,?)");
        statement.setString(1,producto.getNombre());
        statement.setString(2,producto.getMarca());
        statement.setInt(3,producto.getStock());
        statement.setFloat(4,producto.getPrecio());

        statement.executeUpdate();
    }

    public  static void printAll() throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from productos");
        while (rst.next()){
            System.out.println("id = " + rst.getInt("id"));
            System.out.println("nombre = " + rst.getString("nombre"));
            System.out.println("marca = " + rst.getString("marca"));
            System.out.println("stock = " + rst.getInt("stock"));
            System.out.println("precio = " + rst.getFloat("precio"));
            System.out.println("............................................................");

        }
    }
    public  static ArrayList<Producto> getAll() throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from productos");
        ArrayList<Producto> lista = new ArrayList<>();
        while (rst.next()){
            int id = rst.getInt("id");
            String nombre =  rst.getString("nombre");
            String marca =  rst.getString("marca");
            int stock = rst.getInt("stock");
            float precio = rst.getFloat("precio");

            lista.add(new Producto(id,nombre,marca,stock,precio));
        }
        return lista;
    }
}
