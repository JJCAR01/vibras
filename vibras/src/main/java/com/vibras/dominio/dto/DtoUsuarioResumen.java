package com.vibras.dominio.dto;


public class DtoUsuarioResumen {
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String tipoUsuario;
    private String celular;


    public DtoUsuarioResumen(){

    }
    public DtoUsuarioResumen(String nombre, String apellido, String correo,String contrasena, String tipoUsuario,String celular){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.contrasena = contrasena;
        this.celular = celular;
    }
}
