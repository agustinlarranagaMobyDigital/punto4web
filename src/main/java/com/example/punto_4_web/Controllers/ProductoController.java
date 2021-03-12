package com.example.punto_4_web.Controllers;

import com.example.punto_4_web.DAO.ProductoDAO;
import com.example.punto_4_web.Models.Producto;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductoController {


    public static void add() throws SQLException, ClassNotFoundException {

        Producto producto = new Producto();

        ingresarDatosProducto(producto);

        ProductoDAO.add(producto);


    }

    public static void printAll() throws SQLException, ClassNotFoundException {
        ProductoDAO.printAll();
    }


    private static void ingresarDatosProducto(Producto producto){

        //Variables
         String nombre = "";
         String marca = "";
         int stock = 0;
         float precio = 0 ;


        System.out.println("Ingrese los datos del nuevo producto");

        System.out.println("Nombre :");
        Scanner teclado = new Scanner(System.in);
        nombre = teclado. nextLine();

        System.out.println("Marca :");
        //Scanner teclado = new Scanner(System.in);
        marca = teclado. nextLine();

        System.out.println("Stock :");
        // Scanner teclado = new Scanner(System.in);
        stock = Integer.parseInt(teclado. nextLine());

        System.out.println("Precio :");
        // Scanner teclado = new Scanner(System.in);
        precio = Float.parseFloat(teclado. nextLine());



        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setStock(stock);
        producto.setPrecio(precio);
    }
}
