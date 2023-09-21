package com.vibras.infraestructura.controlador;


import com.vibras.aplicacion.dto.DtoLogin;
import com.vibras.aplicacion.dto.DtoRespuesta;
import com.vibras.aplicacion.servicio.login.ServicioAplicacionLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class ControladorLogin {

    private final ServicioAplicacionLogin servicioLogin;

    public ControladorLogin(ServicioAplicacionLogin servicioAplicacionLogin){
        this.servicioLogin = servicioAplicacionLogin;
    }

    @PostMapping
    public DtoRespuesta<String> login(@RequestBody DtoLogin dto){ return  this.servicioLogin.ejecutar(dto);}
}
