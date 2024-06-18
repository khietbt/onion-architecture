package io.github.khietbt.infrastructure.database.r2dbc.repositories;

import io.github.khietbt.infrastructure.database.r2dbc.entities.R2dbcUserEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface R2dbcUserRepository extends R2dbcRepository<R2dbcUserEntity, UUID> {
    Mono<R2dbcUserEntity> getOneById(String id);
}
