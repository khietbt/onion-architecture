package io.github.khietbt.domain.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DomainUserService {
    Mono<DomainUserEntity> findById(UUID id);

    Mono<DomainUserEntity> create(DomainUserEntity user);
}
