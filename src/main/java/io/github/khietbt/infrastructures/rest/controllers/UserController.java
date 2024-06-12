package io.github.khietbt.infrastructures.rest.controllers;

import io.github.khietbt.domains.entities.User;
import io.github.khietbt.domains.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    @Qualifier("cachedUserService")
    private UserService userService;

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable UUID id) throws Exception {
        return Mono.just(this.userService.getById(id));
    }
}
