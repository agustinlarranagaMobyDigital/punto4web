package com.example.punto_4_web.Models;

public class ItemPedido {
    private int id;
    private int id_pedido;
    private String nombre_producto;
    private int cantidad;
    private float monto;

    public ItemPedido(int id_pedido, String nombre_producto, int cantidad, float monto) {
        this.id_pedido = id_pedido;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
