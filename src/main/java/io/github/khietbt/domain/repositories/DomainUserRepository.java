package io.github.khietbt.domain.repositories;

import io.github.khietbt.domain.entities.DomainUserEntity;

import java.util.Optional;
import java.util.UUID;

public interface DomainUserRepository {
    Optional<DomainUserEntity> getOneById(UUID id);

    void create(DomainUserEntity user) throws RuntimeException;
}
