package io.github.khietbt.infrastructures.rest.controllers;

import io.github.khietbt.domains.entities.User;
import io.github.khietbt.domains.services.UserService;
import io.github.khietbt.infrastructures.rest.requests.UserCreationRequest;
import io.github.khietbt.infrastructures.rest.responses.UserCreationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(@Qualifier("cachedUserService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable(value = "id") UUID id) throws Exception {
        try {
            return Mono.just(this.userService.getById(id));
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    @PostMapping
    public Mono<UserCreationResponse> create(@RequestBody UserCreationRequest request) throws Exception {
        var user = User
                .builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .email(request.getEmail())
                .build();

        userService.create(user);

        return Mono.just(
                UserCreationResponse
                        .builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build()
        );
    }
}
