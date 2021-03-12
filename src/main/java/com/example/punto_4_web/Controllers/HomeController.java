package com.example.punto_4_web.Controllers;

import com.example.punto_4_web.Models.Cliente;
import com.example.punto_4_web.Models.Empresa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/formularioCliente")
    public String formularioCliente(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente",cliente);
        model.addAttribute("titulo","Hello world");
        return "formularioCliente";
    }

    @PostMapping("/getFormularioCliente")
    public String getFormularioCliente(Model model, Cliente cliente,@RequestParam String cuit, @RequestParam String condicion_iva){

        try {
            // Agrego los datos del formulario a la base de datos


            if( !cuit.equals("") && !condicion_iva.equals("")){
                Empresa empresa = new Empresa(cliente,cuit,condicion_iva);
                ClienteController.addClienteTipoEmpresa(cliente,empresa);
            }else {
                cliente.setConsumidor_final(true);
                ClienteController.add(cliente);
            }

            // Tomo todos los datos actualizados
            ArrayList<Cliente> lista = ClienteController.getAll();

            //Los guardo en el model para imprimirlos en la vista
            model.addAttribute("lista", lista);
            model.addAttribute("titulo", "Base de datos de los clientes");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "listaClientes";
    }


}
