package com.vibras.dominio.servicio.usuario;


import com.vibras.dominio.modelo.Usuario;
import com.vibras.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarUsuario {
    private static final String MENSAJE_YA_EXISTE = "Ya existe el usuario con los datos ingresados";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioGuardarUsuario(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    public  Long ejecutar(Usuario usuario){
        if(this.repositorioUsuario.existe((usuario))){
            throw  new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return  this.repositorioUsuario.guardar(usuario);
    }
}
