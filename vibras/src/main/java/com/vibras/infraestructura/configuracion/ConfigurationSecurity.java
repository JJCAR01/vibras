package com.vibras.infraestructura.configuracion;


import com.vibras.infraestructura.filtro.FiltroAutenticacion;
import com.vibras.infraestructura.servicio.ServicioValidacionToken;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSecurity {
    private static final String URL_PATTERN = "/*";

    @Bean
    public FilterRegistrationBean<FiltroAutenticacion> autenticationFilter(ServicioValidacionToken servicioValidacionToken){
        FilterRegistrationBean<FiltroAutenticacion> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new FiltroAutenticacion(servicioValidacionToken,new String[]{"/api/login","/api/usuarios"}));
        registrationBean.addUrlPatterns(URL_PATTERN);
        return registrationBean;
    }
}
