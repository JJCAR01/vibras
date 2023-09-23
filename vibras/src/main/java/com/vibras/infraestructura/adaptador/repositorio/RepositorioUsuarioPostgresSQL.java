package com.vibras.infraestructura.adaptador.repositorio;


import com.vibras.dominio.dto.DtoUsuarioResumen;
import com.vibras.dominio.modelo.Usuario;
import com.vibras.dominio.puerto.RepositorioUsuario;
import com.vibras.infraestructura.adaptador.entidad.EntidadRolUsuario;
import com.vibras.infraestructura.adaptador.entidad.EntidadUsuario;
import com.vibras.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioPostgresSQL implements RepositorioUsuario {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioUsuarioPostgresSQL(RepositorioUsuarioJpa repositorioUsuarioJpa){
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }
    @Override
    public List<DtoUsuarioResumen> listar() {
        List<EntidadUsuario> entidades = this.repositorioUsuarioJpa.findAll();
        return entidades.stream().map(entidad -> new DtoUsuarioResumen(entidad.getNombre(),entidad.getApellido(),entidad.getTipoDocumento(),entidad.getNumeroDocumento(), entidad.getCorreo(), entidad.getContrasena(), entidad.getRol(), entidad.getCelular())).toList();
    }

    @Override
    public DtoUsuarioResumen consultarPorId(long id) {
        return null;
    }


    public DtoUsuarioResumen consultarPorId(Long id) {

        return this.repositorioUsuarioJpa
                .findById(id)
                .map(entidad -> new DtoUsuarioResumen(entidad.getNombre(),entidad.getApellido(),entidad.getTipoDocumento(), entidad.getNumeroDocumento(), entidad.getCorreo(), entidad.getContrasena(), entidad.getRol(), entidad.getCelular()))
                .orElse(null);
    }

    public Long guardar(Usuario usuario) {


        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getTipoDocumento(),usuario.getNumeroDocumento(), usuario.getCorreo(), usuario.getContrasena(), usuario.getRol(), usuario.getCelular());

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();

    }

    @Override
    public boolean existe(Usuario usuario) {
        return false;
    }

    @Override
    public Long eliminar(Long id) {
        return null;
    }

    @Override
    public Long modificar(Usuario usuario, Long id) {
        return null;
    }

    @Override
    public Usuario consultar(String usuario, String clave) {
        return null;
    }
}
