package com.vibras.aplicacion.servicio.usuario;



import com.vibras.aplicacion.dto.DtoRespuesta;
import com.vibras.aplicacion.dto.DtoUsuario;
import com.vibras.dominio.modelo.Usuario;
import com.vibras.dominio.servicio.usuario.ServicioEditarUsuario;

import java.util.Arrays;
import java.util.List;

public class ServicioAplicacionEditarUsuario {
    private final ServicioEditarUsuario servicioEditarUsuario;

    public ServicioAplicacionEditarUsuario(ServicioEditarUsuario servicioEditarUsuario){
        this.servicioEditarUsuario = servicioEditarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto, Long codigo){

        Usuario usuario = Usuario.of(dto.getNombre(),dto.getApellido(), dto.getTipoDocumento(), dto.getNumeroDocumento(), dto.getCorreo(),dto.getContrasena(), dto.getRol(), dto.getCelular());
        return
                new DtoRespuesta<>(this.servicioEditarUsuario.ejecutar(usuario, codigo));
    }

}
