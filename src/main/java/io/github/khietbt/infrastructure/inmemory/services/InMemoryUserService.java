package io.github.khietbt.infrastructure.inmemory.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.repositories.DomainUserRepository;
import io.github.khietbt.domain.services.DomainUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class InMemoryUserService implements DomainUserService {
    private final DomainUserRepository inMemoryUserRepository;

    public InMemoryUserService(
            @Qualifier("inMemoryUserRepository") DomainUserRepository inMemoryUserRepository
    ) {
        this.inMemoryUserRepository = inMemoryUserRepository;
    }

    @Override
    public Mono<DomainUserEntity> findById(UUID id) throws RuntimeException {
        return this.inMemoryUserRepository.getOneById(id);
    }

    @Override
    public Mono<DomainUserEntity> create(DomainUserEntity user) {
        return this.inMemoryUserRepository.create(user);
    }
}
