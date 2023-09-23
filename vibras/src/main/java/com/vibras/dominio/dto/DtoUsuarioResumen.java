package com.vibras.dominio.dto;


public class DtoUsuarioResumen {
    private String nombre;
    private String apellido;
    private int tipoDocumento;
    private String numeroDocumento;
    private String correo;
    private String contrasena;
    private String rol;
    private String celular;


    public DtoUsuarioResumen(){

    }
    public DtoUsuarioResumen(String nombre, String apellido,int tipoDocumento,String numeroDocumento, String correo, String contrasena, String rol, String celular){
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
        this.rol = rol;
        this.contrasena = contrasena;
        this.celular = celular;
    }
}
