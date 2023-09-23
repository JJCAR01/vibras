package com.vibras.aplicacion.dto;


import lombok.Getter;

@Getter
public class DtoUsuario {
    private String nombre;
    private String apellido;
    private int tipoDocumento;
    private String numeroDocumento;
    private String correo;
    private String contrasena;
    private String rol;
    private String celular;

    public DtoUsuario(){}

    public DtoUsuario(String nombre, String apellido, int tipoDocumento, String numeroDocumento, String correo, String contrasena, String rol, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.celular = celular;
    }




}
