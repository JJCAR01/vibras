package com.vibras.infraestructura.adaptador.entidad;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rol_usuario")
public class EntidadRolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rol;

    public EntidadRolUsuario(){

    }
    public  EntidadRolUsuario(String rol){
        this.rol = rol;
    }

}
