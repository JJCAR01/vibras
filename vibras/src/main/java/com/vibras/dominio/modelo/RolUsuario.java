package com.vibras.dominio.modelo;


import com.vibras.dominio.utilitario.UtilTexto;

public class RolUsuario {
    private final String rol;

    public static RolUsuario of(String rol) {

        UtilTexto.validarObligatorio(rol, "El rol no puede ser vacio");

        return new RolUsuario(rol);
    }

    private RolUsuario(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
