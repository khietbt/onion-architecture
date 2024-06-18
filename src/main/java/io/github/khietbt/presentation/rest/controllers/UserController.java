package io.github.khietbt.presentation.rest.controllers;

import io.github.khietbt.application.services.ApplicationUserService;
import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.presentation.rest.requests.UserCreateRequest;
import io.github.khietbt.presentation.rest.responses.UserCreateResponse;
import io.github.khietbt.presentation.rest.responses.UserGetOneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public Mono<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
        try {
            var user = DomainUserEntity
                    .builder()
                    .id(UUID.randomUUID())
                    .name(request.getName())
                    .email(request.getEmail())
                    .build();

            applicationUserService.create(user);

            return Mono.just(UserCreateResponse
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
