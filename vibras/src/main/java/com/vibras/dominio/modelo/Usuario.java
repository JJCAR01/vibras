package com.vibras.dominio.modelo;



import com.vibras.dominio.utilitario.UtilNumero;
import com.vibras.dominio.utilitario.UtilTexto;

public class Usuario {
    private final String nombre;
    private final String apellido;
    private final String correo;
    private String contrasena;
    private int tipoUsuario;
    private String celular;

    public static Usuario of(String nombre, String apellido, String correo, String contrasena, int roles,String celular) {
        UtilTexto.validarObligatorio(nombre,"El nombre no puede ser vacio");
        UtilTexto.validarObligatorio(apellido,"El apellido no puede ser vacio");
        UtilTexto.validarObligatorio(correo,"El correo no puede ser vacio");
        UtilTexto.validarObligatorio(contrasena,"La contraseña no puede ser vacia");
        UtilTexto.validarLongitudContrasena(contrasena,"La contraseña debe tener minimo un numero");
        UtilNumero.numeroDiferenteCero(roles,"Rol debe ser diligenciado");
        return  new Usuario(nombre,apellido,correo,contrasena,roles,celular);
    }
    private Usuario(String nombre, String apellido, String correo, String contrasena, int roles,String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = roles;
        this.celular = celular;
    }

    public String getNombre(){
        return  nombre;
    }
    public String getApellido(){
        return  apellido;
    }
    public  String getContrasena(){
        return  contrasena;
    }
    public  int getTipoUsuario(){
        return tipoUsuario;
    }
    public String getCelular(){return celular; }
    public  void  asignarClaveCifrada(String contrasena){
        this.contrasena = contrasena;
    }

}
