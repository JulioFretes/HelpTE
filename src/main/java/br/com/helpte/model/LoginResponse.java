package br.com.helpte.model;

public class LoginResponse {
    private TokenJwt token;
    private String userId;

    public LoginResponse () {}

    public LoginResponse(TokenJwt token, String userId) {
        this.token = token;
        this.userId = userId;
    }
    public TokenJwt getToken() {
        return token;
    }
    public void setToken(TokenJwt token) {
        this.token = token;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}