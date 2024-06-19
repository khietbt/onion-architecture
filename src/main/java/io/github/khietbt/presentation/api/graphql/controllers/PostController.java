package io.github.khietbt.presentation.api.graphql.controllers;

import io.github.khietbt.presentation.api.graphql.responses.PostGetOneResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class PostController {
    @QueryMapping
    private Mono<PostGetOneResponse> getOneById(@Argument(name = "id") String id) {
        return Mono.just(
                PostGetOneResponse
                        .builder()
                        .id(id)
                        .title("graph title")
                        .content("graph content")
                        .build()
        );
    }
}
