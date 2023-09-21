package com.vibras.infraestructura.filtro;

import com.vibras.infraestructura.servicio.ServicioValidacionToken;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class FiltroAutenticacion implements Filter {

    private static final String MENSAJE_TOKEN_INVALIDO = "Token no existe, inválido o caducado";

    private final ServicioValidacionToken servicioValidacionToken;

    private final String[] excludePaths;

    public FiltroAutenticacion(ServicioValidacionToken servicioValidacionToken,String[] excludePaths){
        this.servicioValidacionToken = servicioValidacionToken;
        this.excludePaths = excludePaths;
    }

    //@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!this.servicioValidacionToken.esValido(token)){
            response.sendError(HttpStatus.UNAUTHORIZED.value(),MENSAJE_TOKEN_INVALIDO);
            return;
        }
        filterChain.doFilter(request,response);
    }

    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{

        String path = request.getRequestURI();

        boolean shouldNotFilter = false;
        for (int i=0; i<excludePaths.length;i++){
            String excludePath = excludePaths[i];
            if (path.equals(excludePath)){
                shouldNotFilter = true;
            }
        }
        return shouldNotFilter;
    }
}
