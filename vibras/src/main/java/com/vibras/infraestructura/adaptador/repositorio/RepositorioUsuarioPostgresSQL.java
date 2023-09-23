package com.vibras.infraestructura.adaptador.repositorio;


import com.vibras.dominio.dto.DtoUsuarioResumen;
import com.vibras.dominio.modelo.Usuario;
import com.vibras.dominio.puerto.RepositorioUsuario;
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

    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {

        return this.repositorioUsuarioJpa
                .findById(id)
                .map(entidad -> new DtoUsuarioResumen(entidad.getNombre(),entidad.getApellido(),entidad.getTipoDocumento(), entidad.getNumeroDocumento(), entidad.getCorreo(), entidad.getContrasena(), entidad.getRol(), entidad.getCelular()))
                .orElse(null);
    }

    @Override
    public Long guardar(Usuario usuario) {


        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getTipoDocumento(),usuario.getNumeroDocumento(), usuario.getCorreo(), usuario.getContrasena(), usuario.getRol(), usuario.getCelular());

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();

    }

    @Override
    public boolean existe(Usuario usuario) {

        return this.repositorioUsuarioJpa.findByNombreAndApellido(usuario.getNombre(), usuario.getApellido()) !=null;
    }

    @Override
    public Long eliminar(Long id) {

        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Usuario usuario, Long id) {
        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setId(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellido(usuario.getApellido());
        entidadUsuario.setTipoDocumento(usuario.getTipoDocumento());
        entidadUsuario.setNumeroDocumento(usuario.getNumeroDocumento());
        entidadUsuario.setCorreo(usuario.getCorreo());
        entidadUsuario.setContrasena(usuario.getContrasena());
        entidadUsuario.setRol(usuario.getRol());
        entidadUsuario.setCelular(usuario.getCelular());
        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }

    @Override
    public Usuario consultar(String usuario, String contrasena) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndContrasena(usuario,contrasena);
        if (entidadUsuario == null){
            return  null;
        }

        return Usuario.of(entidadUsuario.getNombre(),entidadUsuario.getApellido(),entidadUsuario.getTipoDocumento(),entidadUsuario.getNumeroDocumento(),entidadUsuario.getCorreo(), entidadUsuario.getContrasena(), entidadUsuario.getRol(), entidadUsuario.getCelular());
    }
}
