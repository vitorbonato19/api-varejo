package br.com.localvarejo.controllers;

import java.time.Instant;
import java.util.stream.Collectors;

import br.com.localvarejo.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.localvarejo.controllers.dto.LoginRequest;
import br.com.localvarejo.controllers.dto.LoginResponse;
import br.com.localvarejo.repository.UserRepository;

@RestController
public class TokenController {

	private final JwtEncoder jwtEncoder;
	
	private final UserRepository repository;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	public TokenController(JwtEncoder jwtEncoder, UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
		this.jwtEncoder = jwtEncoder;
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) 	{
		var user = repository.findByUsername(loginRequest.username());
		
		if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
			throw new BadCredentialsException("User or password is invalid...");
		}
		
		var now = Instant.now();
		var expiresIn = 30L;

		var scopes = user.get().getRoleSet()
				.stream()
				.map(Role::getName)
				.collect(Collectors.joining(" "));

		var claims = JwtClaimsSet.builder()
				.issuer("backend-java")
				.subject(user.get().getUserId().toString())
				.issuedAt(now)
				.claim("scope", scopes)
				.expiresAt(now.plusSeconds(expiresIn))
				.build();
		
		var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
		
		return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn, Instant.now()));
	}
}
