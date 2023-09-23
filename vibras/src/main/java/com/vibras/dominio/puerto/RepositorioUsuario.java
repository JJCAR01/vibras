package com.vibras.dominio.puerto;

import com.vibras.dominio.dto.DtoUsuarioResumen;
import com.vibras.dominio.modelo.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    List<DtoUsuarioResumen> listar();
    DtoUsuarioResumen consultarPorId(long id);

    DtoUsuarioResumen consultarPorId(Long id);

    Long guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    Long eliminar(Long id);
    Long modificar(Usuario usuario,Long id);
    Usuario consultar(String usuario, String clave);
}
