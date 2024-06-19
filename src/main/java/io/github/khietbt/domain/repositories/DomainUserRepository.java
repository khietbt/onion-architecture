package io.github.khietbt.domain.repositories;

import io.github.khietbt.domain.entities.DomainUserEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DomainUserRepository {
    Mono<DomainUserEntity> getOneById(UUID id);

    Mono<DomainUserEntity> create(DomainUserEntity user);
}
