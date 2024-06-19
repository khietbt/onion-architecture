package io.github.khietbt.presentation.api.webflux.controllers;

import io.github.khietbt.application.services.ApplicationUserService;
import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.presentation.api.webflux.requests.UserCreateRequest;
import io.github.khietbt.presentation.api.webflux.responses.UserCreateResponse;
import io.github.khietbt.presentation.api.webflux.responses.UserGetOneResponse;
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
    public Mono<UserGetOneResponse> getOne(@PathVariable(name = "id") String id) {

        return applicationUserService.findById(UUID.fromString(id))
                .map(
                        user ->
                                UserGetOneResponse
                                        .builder()
                                        .id(user.getId())
                                        .name(user.getName())
                                        .email(user.getEmail())
                                        .build()
                );
    }

    @PostMapping
    public Mono<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
        try {
            return applicationUserService.create(
                            DomainUserEntity
                                    .builder()
                                    .id(UUID.randomUUID())
                                    .name(request.getName())
                                    .email(request.getEmail())
                                    .build())
                    .map(
                            user -> UserCreateResponse
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
