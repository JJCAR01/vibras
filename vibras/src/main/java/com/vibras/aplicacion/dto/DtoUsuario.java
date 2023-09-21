package com.vibras.aplicacion.dto;


public class DtoUsuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private int tipoUsuario;
    private String celular;

    public DtoUsuario(){}

    public DtoUsuario(String nombre, String apellido, String correo, String contrasena, int tipoUsuario,String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public String getContrasena(){ return contrasena;}
    public String getCelular(){ return  celular;}
    public String getCorreo(){ return  correo;}

    public int getTipoUsuario(){ return  tipoUsuario; }


}
