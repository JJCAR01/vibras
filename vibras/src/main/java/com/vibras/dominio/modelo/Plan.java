package com.vibras.dominio.modelo;


import com.vibras.dominio.utilitario.UtilNumero;
import com.vibras.dominio.utilitario.UtilTexto;

public class Plan {
    private final String descripcionPlan;
    private final int valor;

    public static Plan of(String descripcionPlan, int valor){

        UtilTexto.validarObligatorio(descripcionPlan,"El plan debe tener una descripcion");
        UtilNumero.numeroDiferenteCero(valor,"El valor de plan no puede ser cero");
        UtilNumero.numeroNoPuedeSerNegativo(valor,"El valor de plan no puede ser negativo");

        return new Plan(descripcionPlan,valor);
    }

    private Plan(String descripcionPlan, int valor) {
        this.descripcionPlan = descripcionPlan;
        this.valor = valor;
    }

    public String getDescripcionPlan(){
        return descripcionPlan;
    }
    public  int getValor(){
        return  valor;
    }

}
