package com.vibras.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "usuarios")

public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private int tipoDocumento;
    private String numeroDocumento;
    private String correo;
    private String contrasena;
    private String rol;
    private String celular;


    public EntidadUsuario(String nombre,String apellido,int tipoDocumento, String numeroDocumento,String correo,String contrasena,String rol,String celular){
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.contrasena = contrasena;
        this.rol = rol;
        this.correo = celular;
    }
}
