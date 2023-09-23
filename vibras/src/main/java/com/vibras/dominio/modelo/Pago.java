package com.vibras.dominio.modelo;

public class Pago {
    private long usuario;
    private long plan;
    private String formaPago;

    public static  Pago of(long usuario, long plan, String formaPago){


        return new Pago(usuario, plan, formaPago);
    }

    public Pago(long usuario, long plan, String formaPago) {
        this.usuario = usuario;
        this.plan = plan;
        this.formaPago = formaPago;
    }
}
