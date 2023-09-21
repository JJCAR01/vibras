package com.vibras.dominio.puerto;

import com.vibras.dominio.modelo.Plan;

import java.util.List;

public interface RepositorioPlan {
    List<Plan> listar();
    Plan consultarPorId(Long id);
    Long guardar(Plan plan);
    boolean existe(Plan plan);
    Long eliminar(Long id);
    Long modificar(Plan plan, Long id);

}
