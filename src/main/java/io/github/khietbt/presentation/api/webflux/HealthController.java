package io.github.khietbt.presentation.api.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/health")
@RestController
public class HealthController {
    @GetMapping
    public Mono<String> getOne() {
        return Mono.just("OK");
    }
}
