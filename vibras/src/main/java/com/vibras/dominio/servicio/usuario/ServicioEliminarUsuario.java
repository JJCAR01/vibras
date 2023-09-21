package com.vibras.dominio.servicio.usuario;


import com.vibras.dominio.puerto.RepositorioUsuario;

public class ServicioEliminarUsuario {
    private static final String MENSAJE_NO_EXISTE ="No existe el Usuario con los datos ingresados";

    private  final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }
    public  Long ejecutar(Long codigo){
        if(this.repositorioUsuario.consultarPorId(codigo)==null){
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return  this.repositorioUsuario.eliminar(codigo);
    }
}
