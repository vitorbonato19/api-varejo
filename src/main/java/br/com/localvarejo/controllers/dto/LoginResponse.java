package br.com.localvarejo.controllers.dto;

public record LoginResponse(String acessToken, Long expiresIn) {

}
