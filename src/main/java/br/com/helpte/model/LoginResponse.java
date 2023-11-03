package br.com.helpte.model;

import br.com.helpte.entity.Usuario;

public class LoginResponse {
    private TokenJwt token;
    private Usuario user;

    public LoginResponse () {}

    public LoginResponse(TokenJwt token, Usuario user) {
        this.token = token;
        this.user = user;
    }
    public TokenJwt getToken() {
        return token;
    }
    public void setToken(TokenJwt token) {
        this.token = token;
    }
    public Usuario getUser() {
        return user;
    }
    public void setUser(Usuario user) {
        this.user = user;
    }
}