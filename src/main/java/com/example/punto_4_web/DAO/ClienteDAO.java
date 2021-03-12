package com.example.punto_4_web.DAO;

import com.example.punto_4_web.Models.Cliente;
import com.example.punto_4_web.Models.Empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements Irepository{

//-------------- ADDS
    public static void add(Cliente cliente) throws SQLException, ClassNotFoundException {


        Connection instancia = ConecctionDataBase.getInstance();
        PreparedStatement statement = instancia.prepareStatement("INSERT INTO clientes(nombre,apellido,dni,telefono,consumidor_final) " +
                "VALUES(?,?,?,?,?)");
        statement.setString(1,cliente.getNombre());
        statement.setString(2,cliente.getApellido());
        statement.setString(3,cliente.getDni());
        statement.setString(4,cliente.getTelefono());
        statement.setBoolean(5,cliente.isConsumidor_final());

        statement.executeUpdate();
    }


    public static void addTipoEmpresa(Empresa empresa) throws SQLException, ClassNotFoundException {

        int id_cliente = getIdLastInsert();

        Connection instancia = ConecctionDataBase.getInstance();
        PreparedStatement statement = instancia.prepareStatement("INSERT INTO tipo_empresa(id_cliente,cuit,condicion_iva) " +
                "VALUES(?,?,?)");
        statement.setInt(1,id_cliente);
        statement.setString(2,empresa.getCuit());
        statement.setString(3,empresa.getCondicion_iva());


        statement.executeUpdate();
    }

//----------------------- PRINT
    public  static void printAll() throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from clientes");
        while (rst.next()){
            System.out.println("id = " + rst.getInt("id"));
            int id = rst.getInt("id");
            System.out.println("nombre = " + rst.getString("nombre"));
            System.out.println("apellido = " + rst.getString("apellido"));
            System.out.println("dni = " + rst.getString("dni"));
            System.out.println("telefono = " + rst.getString("telefono"));
            System.out.println("consumidor_final = " + rst.getBoolean("consumidor_final"));
            boolean consumidor_final = rst.getBoolean("consumidor_final");

        }
    }
//------------------------- GET()
    private static int getIdLastInsert() throws SQLException, ClassNotFoundException {
        int id = 0;
        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("SELECT MAX(id) as id FROM clientes");
        while (rst.next()){
            id = rst.getInt("id");
        }

        return id;
    }

    public static Cliente  getById( int id) throws SQLException, ClassNotFoundException {
        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from clientes where id = " + id);
        Cliente cliente =  new Cliente();
        while (rst.next()){
            cliente.setId(rst.getInt("id"));
            cliente.setNombre(rst.getString("nombre"));
            cliente.setApellido(rst.getString("apellido"));
            cliente.setDni(rst.getString("dni"));
            cliente.setTelefono(rst.getString("telefono"));
            cliente.setConsumidor_final(rst.getBoolean("consumidor_final"));
        }
        return cliente;
    }

    public static ArrayList<Cliente> getAll() throws SQLException, ClassNotFoundException{
        // Inicializando
        Cliente cliente = null;
        ArrayList<Cliente> lista = new ArrayList();
        Empresa empresa = null;

        // Connection
        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from clientes");
        // Get de la base de datos
        while (rst.next()){
            cliente = new Cliente();
            cliente.setId(rst.getInt("id"));
            cliente.setNombre(rst.getString("nombre"));
            cliente.setApellido(rst.getString("apellido"));
            cliente.setDni(rst.getString("dni"));
            cliente.setTelefono(rst.getString("telefono"));
            cliente.setConsumidor_final(rst.getBoolean("consumidor_final"));

            // Si es de tipo empresa tambien guardo sus datos
            if ( !cliente.isConsumidor_final()){

                empresa = new Empresa(cliente,"","");
                setEmpresaByIdCliente(cliente.getId(), empresa);
                lista.add(empresa);
            }else {  // Si es solo cliente
                lista.add(cliente);
            }
        }
        return lista;
    }

    private static void setEmpresaByIdCliente(int id_cliente, Empresa empresa) throws SQLException, ClassNotFoundException {

        Connection instancia = ConecctionDataBase.getInstance();
        Statement statement = instancia.createStatement();
        ResultSet rst = statement.executeQuery("select * from tipo_empresa where id_cliente = " + id_cliente);

        while (rst.next()){
            empresa.setCuit(rst.getString("cuit"));
            empresa.setCondicion_iva(rst.getString("condicion_iva"));
        }
    }
}
