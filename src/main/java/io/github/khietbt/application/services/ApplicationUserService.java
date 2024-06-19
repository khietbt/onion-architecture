package io.github.khietbt.application.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.services.DomainUserService;
import io.github.khietbt.infrastructure.database.r2dbc.services.R2dbcUserService;
import io.github.khietbt.infrastructure.inmemory.services.InMemoryUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
public class ApplicationUserService implements DomainUserService {
    private final DomainUserService inMemoryUserService;
    private final DomainUserService databaseUserService;

    public ApplicationUserService(
            InMemoryUserService inMemoryUserService,
            R2dbcUserService databaseUserService
    ) {
        this.inMemoryUserService = inMemoryUserService;
        this.databaseUserService = databaseUserService;
    }

    @Override
    public Mono<DomainUserEntity> findById(UUID id) {
        return this.inMemoryUserService.findById(id)
                .switchIfEmpty(
                        this.databaseUserService.findById(id)
                                .flatMap(this.inMemoryUserService::create)
                );
    }

    @Override
    public Mono<DomainUserEntity> create(DomainUserEntity user) {
        return this.databaseUserService.create(user);
    }
}
