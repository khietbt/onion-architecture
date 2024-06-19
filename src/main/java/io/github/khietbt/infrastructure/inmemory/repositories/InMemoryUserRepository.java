package io.github.khietbt.infrastructure.inmemory.repositories;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.repositories.DomainUserRepository;
import io.github.khietbt.infrastructure.inmemory.entities.InMemoryUserEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryUserRepository implements DomainUserRepository {
    public Map<UUID, InMemoryUserEntity> inMemoryUsers = new HashMap<>();

    @Override
    public Mono<DomainUserEntity> getOneById(UUID id) {
        return Mono.justOrEmpty(
                inMemoryUsers.get(id)
        ).map(
                (inMemoryUser) -> DomainUserEntity
                        .builder()
                        .id(inMemoryUser.getId())
                        .name(inMemoryUser.getName())
                        .email(inMemoryUser.getEmail())
                        .build()
        );
    }

    @Override
    public Mono<DomainUserEntity> create(DomainUserEntity user) {
        inMemoryUsers.put(
                user.getId(), InMemoryUserEntity
                        .builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .cachedAt(new Date())
                        .build()
        );

        return Mono.just(user);
    }
}
