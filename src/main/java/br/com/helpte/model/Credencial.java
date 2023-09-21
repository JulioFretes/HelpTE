package br.com.helpte.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public record Credencial (String usuario, String senha) {

    public Authentication toAuthentication() {
        return new UsernamePasswordAuthenticationToken(usuario, senha);
    }

}