package com.vibras.infraestructura.aspectos.servicio;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Component
public class AuthorizationService {
    private final Environment environment;
    public AuthorizationService(Environment environment){ this.environment = environment;}

    public boolean isAuthorized(String roleToAutorized){
        String token = obtenerTokenActual();
        final SigningKeyResolver firma = obtenerFirma();
        String roles = obtenerRoles(token, firma);
        return roles.indexOf(roleToAutorized) != -1;
    }

    private String obtenerRoles(String token, SigningKeyResolver signingKeyResolver) {
        return (String) Jwts.parser()
                .setSigningKeyResolver(signingKeyResolver)
                .parseClaimsJws(token).getBody().get("roles");
    }

    private SigningKeyResolver obtenerFirma() {
        final SigningKeyResolver signingKeyResolver = new SigningKeyResolverAdapter() {
            @Override
            public byte[] resolveSigningKeyBytes(@SuppressWarnings("rawtypes") JwsHeader header, Claims claims) {
                return TextCodec.BASE64.decode(AuthorizationService.this.environment.getRequiredProperty("token.key"));
            }
        };
        return signingKeyResolver;
    }
    private String obtenerTokenActual() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }
}
