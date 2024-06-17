package io.github.khietbt.infrastructure.inmemory.repositories;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.repositories.DomainUserRepository;
import io.github.khietbt.infrastructure.inmemory.entities.InMemoryUserEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryUserRepository implements DomainUserRepository {
    public Map<UUID, InMemoryUserEntity> inMemoryUsers = new HashMap<>();

    @Override
    public Optional<DomainUserEntity> getById(UUID id) {
        return Optional
                .ofNullable(inMemoryUsers.get(id))
                .map(
                        (inMemoryUser) -> DomainUserEntity
                                .builder()
                                .id(inMemoryUser.getId())
                                .name(inMemoryUser.getName())
                                .email(inMemoryUser.getEmail())
                                .build()
                );
    }
}
