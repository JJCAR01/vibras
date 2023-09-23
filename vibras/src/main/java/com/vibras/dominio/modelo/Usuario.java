package com.vibras.dominio.modelo;



import com.vibras.dominio.utilitario.UtilNumero;
import com.vibras.dominio.utilitario.UtilTexto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private final String nombre;
    private final String apellido;
    private final int tipoDocumento;
    private final String numeroDocumento;
    private final String correo;
    private  String contrasena;
    private final String rol;
    private final String celular;

    public static Usuario of(String nombre, String apellido,int tipoDocumento,String numeroDocumento, String correo, String contrasena,String rol,String celular) {
        UtilTexto.validarObligatorio(nombre,"El nombre no puede ser vacio");
        UtilTexto.validarObligatorio(apellido,"El apellido no puede ser vacio");
        UtilNumero.numeroNoPuedeSerNegativo(tipoDocumento,"tipo de documento no puede ser negativo");
        UtilTexto.validarObligatorio(numeroDocumento,"El numero de documento no puede vacio");
        UtilTexto.validarObligatorio(correo,"El correo no puede ser vacio");
        UtilTexto.validarObligatorio(contrasena,"La contraseña no puede ser vacia");
        UtilTexto.validarLongitudContrasena(contrasena,"La contraseña debe tener minimo un numero");
        UtilTexto.validarObligatorio(rol,"El rol no puede ser vacio");

        return  new Usuario(nombre,apellido,tipoDocumento,numeroDocumento,correo,contrasena,rol,celular);
    }
    private Usuario(String nombre, String apellido,int tipoDocumento,String numeroDocumento, String correo, String contrasena, String roles,String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = roles;
        this.celular = celular;
    }


    public  void  asignarClaveCifrada(String contrasena){
        this.contrasena = contrasena;
    }

}
