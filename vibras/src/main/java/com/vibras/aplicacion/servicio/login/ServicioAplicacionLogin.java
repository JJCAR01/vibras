package com.vibras.aplicacion.servicio.login;

import com.vibras.aplicacion.dto.DtoLogin;
import com.vibras.aplicacion.dto.DtoRespuesta;
import com.vibras.dominio.modelo.Usuario;
import com.vibras.dominio.puerto.RepositorioUsuario;
import com.vibras.dominio.servicio.ServicioCifrarTexto;
import com.vibras.dominio.servicio.ServicioGenerarToken;

public class ServicioAplicacionLogin {

    private final ServicioGenerarToken servicioGenerarToken;
    private final ServicioCifrarTexto servicioCifrarTexto;
    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionLogin(ServicioGenerarToken servicioGenerarToken,ServicioCifrarTexto servicioCifrarTexto,RepositorioUsuario repositorioUsuario){
        this.servicioGenerarToken = servicioGenerarToken;
        this.servicioCifrarTexto = servicioCifrarTexto;
        this.repositorioUsuario = repositorioUsuario;
    }

    public DtoRespuesta<String> ejecutar(DtoLogin dto){
        String calveCifrado = this.servicioCifrarTexto.ejecutar(dto.getClave());
        Usuario usuario = this.repositorioUsuario.consultar(dto.getUsuario(), calveCifrado);

        if(usuario == null){
            throw new IllegalStateException("usuario o clave incorrecta");
        }
        String roles = usuario.getTipoUsuario();
        return  new DtoRespuesta<>(this.servicioGenerarToken.ejecutar(dto.getUsuario(), roles));
    }
}
