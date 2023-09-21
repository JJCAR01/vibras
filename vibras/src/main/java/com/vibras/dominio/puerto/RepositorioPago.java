package com.vibras.dominio.puerto;


import com.vibras.dominio.modelo.Pago;

import java.util.List;

public interface RepositorioPago {
    List<Pago> listar();
    Pago consultarPorId(Long id);
    Long guardar(Pago pago);
    boolean existe(Pago pago);
    Long eliminar(Long id);
    Long modificar(Pago pago,Long id);
}
