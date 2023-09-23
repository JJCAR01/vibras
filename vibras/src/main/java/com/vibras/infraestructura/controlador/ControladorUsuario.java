package com.vibras.infraestructura.controlador;


import com.vibras.aplicacion.dto.DtoRespuesta;
import com.vibras.aplicacion.dto.DtoUsuario;
import com.vibras.aplicacion.servicio.usuario.ServicioAplicacionEditarUsuario;
import com.vibras.aplicacion.servicio.usuario.ServicioAplicacionEliminarUsuario;
import com.vibras.aplicacion.servicio.usuario.ServicioAplicacionGuardarUsuario;
import com.vibras.aplicacion.servicio.usuario.ServicioAplicacionListarUsuario;
import com.vibras.dominio.dto.DtoUsuarioResumen;
import com.vibras.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {

    private final ServicioAplicacionListarUsuario servicioListarUsuario;
    private final ServicioAplicacionGuardarUsuario servicioGuardarUsuario;
    private final ServicioAplicacionEliminarUsuario servicioEliminarUsuario;
    private final ServicioAplicacionEditarUsuario servicioEditarUsuario;

    public ControladorUsuario(ServicioAplicacionListarUsuario servicioListarUsuario, ServicioAplicacionGuardarUsuario servicioGuardarUsuario, ServicioAplicacionEliminarUsuario servicioEliminarUsuario, ServicioAplicacionEditarUsuario servicioEditarUsuario) {
        this.servicioListarUsuario = servicioListarUsuario;
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioEliminarUsuario = servicioEliminarUsuario;
        this.servicioEditarUsuario = servicioEditarUsuario;
    }

    @GetMapping
    @SecuredResource(name = "usuarios")
    public List<DtoUsuarioResumen> listar(){ return servicioListarUsuario.ejecutar();}

    @GetMapping("/{codigo}")
    public DtoUsuarioResumen listar(@PathVariable long codigo) { return servicioListarUsuario.consultar(codigo);}
    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario dto){ return this.servicioGuardarUsuario.ejecutar(dto);}

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoUsuario usuario,@PathVariable Long codigo){
        return this.servicioEditarUsuario.ejecutar(usuario,codigo);
    }
    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){ return this.servicioEliminarUsuario.ejecutar(codigo);}
}
