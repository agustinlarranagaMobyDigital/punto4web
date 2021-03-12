package com.example.punto_4_web.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConecctionDataBase {

    private static Connection  instancia;
    private static String url = "jdbc:mysql://localhost:3306/guiamobydigital";
    private static String username = "root";
    private static String password = "";


    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if(instancia == null){
            instancia =  DriverManager.getConnection(url,username,password);;
        }
        return instancia;
    }

}
