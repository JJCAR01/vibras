package com.vibras.infraestructura.adaptador.repositorio.jpa;

import com.vibras.infraestructura.adaptador.entidad.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioJpa extends JpaRepository<EntidadUsuario,Long> {
    EntidadUsuario findByNombreAndApellido(String nombre,String apellido);
    EntidadUsuario findByNombreAndContrasena(String usuario,String clave);

}
