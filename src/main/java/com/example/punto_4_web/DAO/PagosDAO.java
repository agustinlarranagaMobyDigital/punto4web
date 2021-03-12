package com.example.punto_4_web.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PagosDAO {

    public static void add(int id_cliente,int id_pedido, float total,String forma_de_pago) throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        PreparedStatement statement = instancia.prepareStatement("INSERT INTO pagos(id_cliente,id_pedido,total,fecha,forma_de_pago) " +
                "VALUES(?,?,?,?,?)");
        statement.setInt(1,id_cliente);
        statement.setInt(2,id_pedido);
        statement.setFloat(3,total);
        Date fecha = getFechaActual();
        statement.setDate(4, fecha);
        statement.setString(5,forma_de_pago);

        statement.executeUpdate();
    }
    private static Date getFechaActual(){
        java.util.Date utilDate = new java.util.Date();
        Date sqlDate = new Date(utilDate.getTime());
        return sqlDate;
    }
}
