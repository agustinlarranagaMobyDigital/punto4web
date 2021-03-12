package com.example.punto_4_web.Models;

public class Empresa extends Cliente{

    private int id_cliente;
    private String cuit;
    private String condicion_iva;

    public Empresa( Cliente c, String cuit, String condicion_iva) {
        super(c);
        this.cuit = cuit;
        this.condicion_iva = condicion_iva;
    }

    public Empresa() {
        super();
    }
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCondicion_iva() {
        return condicion_iva ;
    }

    public void setCondicion_iva(String condicion_iva) {
        this.condicion_iva = condicion_iva;
    }


}

