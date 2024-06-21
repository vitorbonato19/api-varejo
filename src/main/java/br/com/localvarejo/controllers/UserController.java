package br.com.localvarejo.controllers;

import br.com.localvarejo.controllers.dto.CreateUserDto;
import br.com.localvarejo.model.Role;
import br.com.localvarejo.model.User;
import br.com.localvarejo.repository.RoleRepository;
import br.com.localvarejo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @PostMapping("/users")
    public ResponseEntity<Void> newUser(@RequestBody CreateUserDto userDto){

        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());
        var userFromDb = userRepository.findByUsername(userDto.username());
        if(userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = new User();
        user.setUsername(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRoleSet(Set.of(basicRole));
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<User>> findAll() {
        var users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }


}
