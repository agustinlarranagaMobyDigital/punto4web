package com.example.punto_4_web.Controllers;

import com.example.punto_4_web.DAO.ClienteDAO ;
import com.example.punto_4_web.DAO.PagosDAO;
import com.example.punto_4_web.DAO.PedidoDAO;
import com.example.punto_4_web.DAO.ProductoDAO;
import com.example.punto_4_web.Models.Cliente;
import com.example.punto_4_web.Models.Pedido;
import com.example.punto_4_web.Models.Producto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PedidoController {

    public static void hacerPedido() throws SQLException, ClassNotFoundException {

        //---------------------------------------------- Agarro 1 usuario por ejemplo el 15
        Cliente cliente = ClienteDAO.getById(15);


        // A modo de ejemplo solo agarro los que tengan id mayor a  5
        ArrayList<Producto> listaProductos = ProductoDAO.getAll();

        Stream<Producto> Sprodutos = listaProductos.stream()
                .filter(p -> p.getId() >= 6 );


        List<Producto> listaPedido = (List<Producto>) Sprodutos.collect(Collectors.toList());
        //---------------------------------------------- Hacer pedido

        float monto = 0;
        for (Producto p: listaPedido) {
            monto += p.getPrecio();
        }

        PedidoDAO.add(cliente.getId(),monto);
    }

    public static void cobrar(int id_pedido) throws SQLException, ClassNotFoundException {

        Pedido pedido = PedidoDAO.getById(id_pedido);
        Cliente cliente = ClienteDAO.getById( pedido.getId_user() );

        String forma_de_pago = ClienteController.asignarPago(cliente);
        float total = calcularTotalNeto(pedido,forma_de_pago);

        PagosDAO.add(cliente.getId(), id_pedido,total,forma_de_pago);

    }


    private static float calcularTotalNeto(Pedido pedido, String metodo_pago){
        float total = pedido.getMonto();
        if (metodo_pago == "Efectivo"){
           total -=  pedido.getMonto()*0.15;

        }else if(metodo_pago == "Tarjeta"){
            total -=  pedido.getMonto()*0.10;
        }
        return total;
    }


}
