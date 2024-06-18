package io.github.khietbt.infrastructure.inmemory.repositories;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.repositories.DomainUserRepository;
import io.github.khietbt.infrastructure.inmemory.entities.InMemoryUserEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryUserRepository implements DomainUserRepository {
    public Map<UUID, InMemoryUserEntity> inMemoryUsers = new HashMap<>();

    @Override
    public Optional<DomainUserEntity> getOneById(UUID id) {
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

    @Override
    public void create(DomainUserEntity user) throws RuntimeException {
        inMemoryUsers.put(user.getId(), InMemoryUserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .cachedAt(new Date())
                .build());
    }
}
