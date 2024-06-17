package io.github.khietbt.domain.services;

import io.github.khietbt.domain.entities.DomainUserEntity;

import java.util.UUID;

public interface DomainUserService {
    DomainUserEntity findById(UUID id) throws RuntimeException;
}
