package com.vibras.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "usuario")
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

   // @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JoinColumn(name = "id_usuario")

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
