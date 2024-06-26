package br.com.localvarejo.controllers.dto;

import java.time.Instant;

public record LoginResponse(String accessToken, Long expiresIn, Instant created) {

}
