package com.vibras.aplicacion.servicio.usuario;


import com.vibras.aplicacion.dto.DtoRespuesta;
import com.vibras.aplicacion.dto.DtoUsuario;
import com.vibras.dominio.modelo.Usuario;
import com.vibras.dominio.servicio.ServicioCifrarTexto;
import com.vibras.dominio.servicio.usuario.ServicioGuardarUsuario;

import java.util.Arrays;
import java.util.List;

public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final ServicioCifrarTexto servicioCifrarTexto;
    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario,ServicioCifrarTexto servicioCifrarTexto){
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }
    public DtoRespuesta<Long> ejecutar(DtoUsuario dto){

        Usuario usuario = Usuario.of(dto.getNombre(), dto.getApellido(), dto.getTipoDocumento(), dto.getNumeroDocumento(), dto.getCorreo(), dto.getContrasena(), dto.getRol(), dto.getCelular());
        String claveCifrado = this.servicioCifrarTexto.ejecutar(usuario.getContrasena());
        usuario.asignarClaveCifrada(claveCifrado);
        return  new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutar(usuario));
    }
}
