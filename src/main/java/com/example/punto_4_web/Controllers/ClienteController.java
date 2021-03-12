package com.example.punto_4_web.Controllers;

import com.example.punto_4_web.DAO.ClienteDAO;
import com.example.punto_4_web.Models.Cliente;
import com.example.punto_4_web.Models.Empresa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteController {


    public static void add(Cliente cliente) throws SQLException, ClassNotFoundException {
        ClienteDAO.add(cliente);
    }

    public static void addClienteTipoEmpresa(Cliente cliente, Empresa empresa) throws SQLException, ClassNotFoundException {
            add(cliente);
            ClienteDAO.addTipoEmpresa(empresa);
    }
    public static void printAll() throws SQLException, ClassNotFoundException {
        ClienteDAO.printAll();
    }

    public static ArrayList<Cliente> getAll() throws SQLException, ClassNotFoundException {
        return ClienteDAO.getAll();
    }


    /*
    * Return : 1.Efectivo
    *          2: Tarjeta*/
    public static String asignarPago(Cliente cliente){

        if(cliente.isConsumidor_final()==true){ return "Efectivo";}
        else { return "Tarjeta";}
    }

    private static void ingresarDatosClientes(Cliente cliente, Empresa empresa){

        //Variables
        String nombre;
        String apellido;
        String dni;
        String telefono;
        String consumidor;
        boolean consumidor_final;
        String cuit;
        String condicion_iva;


        System.out.println("Ingrese los datos del nuevo cliente");

        System.out.println("Nombre :");
        Scanner teclado = new Scanner(System.in);
        nombre = teclado. nextLine();

        System.out.println("Apellido :");
        //Scanner teclado = new Scanner(System.in);
        apellido = teclado. nextLine();

        System.out.println("Dni :");
        // Scanner teclado = new Scanner(System.in);
        dni = teclado. nextLine();

        System.out.println("Telefono :");
        // Scanner teclado = new Scanner(System.in);
        telefono = teclado. nextLine();

        System.out.println("Es usted consumidor final? 1 = SI    2 = NO");
        //  Scanner teclado = new Scanner(System.in);
        consumidor = teclado.nextLine();

        if(consumidor.equals("2")){
            consumidor_final = false;
            System.out.println("Cuit :");
            //  Scanner teclado = new Scanner(System.in);
            cuit = teclado. nextLine();

            System.out.println("Condicion iva :");
            //    Scanner teclado = new Scanner(System.in);
            condicion_iva = teclado. nextLine();

            empresa.setCuit(cuit);
            empresa.setCondicion_iva(condicion_iva);
        }else{
            consumidor_final = true;
        }

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setTelefono(telefono);
        cliente.setConsumidor_final(consumidor_final);



    }
}
