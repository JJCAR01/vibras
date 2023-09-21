package com.vibras.aplicacion.servicio.usuario;


import com.vibras.aplicacion.dto.DtoRespuesta;
import com.vibras.dominio.servicio.usuario.ServicioEliminarUsuario;

public class ServicioAplicacionEliminarUsuario {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ServicioAplicacionEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario){
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(long codigo){
        return new DtoRespuesta<>(this.servicioEliminarUsuario.ejecutar(codigo));
    }
}
