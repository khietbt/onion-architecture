package io.github.khietbt.presentation.rest.controllers;

import io.github.khietbt.application.services.ApplicationUserService;
import io.github.khietbt.presentation.rest.responses.UserGetOneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private ApplicationUserService applicationUserService;

    @GetMapping("/{id}")
    public Mono<UserGetOneResponse> getOne(@PathVariable(name = "id") UUID id) {
        try {
            var user = applicationUserService.findById(id);

            return Mono.just(
                    UserGetOneResponse
                            .builder()
                            .id(user.getId())
                            .name(user.getName())
                            .email(user.getEmail())
                            .build()
            );
        } catch (Exception e) {
            return Mono.error(e);
        }
    }
}