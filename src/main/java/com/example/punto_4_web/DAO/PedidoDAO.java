package com.example.punto_4_web.DAO;

import com.example.punto_4_web.Models.Pedido;

import java.sql.*;

public class PedidoDAO {

    public static void add(int id_user, float monto) throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        PreparedStatement statement = instancia.prepareStatement("INSERT INTO pedidos(id_user,monto,fecha) " +
                "VALUES(?,?,?)");
        statement.setInt(1,id_user);
        statement.setFloat(2,monto);
        Date fecha = getFechaActual();
        statement.setDate(3, fecha);

        statement.executeUpdate();
    }


    private static Date getFechaActual(){
        java.util.Date utilDate = new java.util.Date();
        Date sqlDate = new Date(utilDate.getTime());
        return sqlDate;
    }

    public  static void printAll() throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from pedidos");
        while (rst.next()){
            System.out.println("id = " + rst.getInt("id"));
            System.out.println("id_user = " + rst.getInt("id_user"));
            System.out.println("monto = " + rst.getFloat("monto"));
            System.out.println("fecha = " + rst.getDate("fecha"));
            System.out.println("............................................................");

        }
    }

    public static Pedido getById(int id) throws SQLException, ClassNotFoundException {
        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from pedidos where id = " + id);
        Pedido pedido =  new Pedido();
        while (rst.next()){
            pedido.setId(rst.getInt("id"));
            pedido.setId_user(rst.getInt("id_user"));
            pedido.setMonto(rst.getFloat("monto"));
            pedido.setFecha(rst.getDate("fecha"));

        }
        return pedido;
    }
}
