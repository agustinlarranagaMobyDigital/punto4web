package com.example.punto_4_web.Models;

import java.util.Date;

public class Pedido {

    private int id;
    private int id_user;
    private float monto;
    private Date fecha;

    public Pedido(int id_user, float monto, Date fecha) {
        this.id_user = id_user;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Pedido(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
