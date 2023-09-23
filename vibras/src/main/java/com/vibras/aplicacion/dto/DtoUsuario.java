package com.vibras.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoUsuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private int tipoUsuario;
    private String celular;


}
