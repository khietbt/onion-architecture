package io.github.khietbt.infrastructure.database.r2dbc.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.services.DomainUserService;
import io.github.khietbt.infrastructure.database.r2dbc.entities.R2dbcUserEntity;
import io.github.khietbt.infrastructure.database.r2dbc.repositories.R2dbcUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Primary
public class R2dbcUserService implements DomainUserService {
    private final R2dbcUserRepository r2dbcUserRepository;

    public R2dbcUserService(R2dbcUserRepository r2dbcUserRepository) {
        this.r2dbcUserRepository = r2dbcUserRepository;
    }

    @Override
    public Mono<DomainUserEntity> findById(UUID id) {
        return this.r2dbcUserRepository
                .getOneById(id.toString())
                .map(
                        (r) -> DomainUserEntity
                                .builder()
                                .id(UUID.fromString(r.getId()))
                                .name(r.getName())
                                .email(r.getEmail())
                                .build()
                );
    }

    @Override
    public Mono<DomainUserEntity> create(DomainUserEntity user) {
        return this.r2dbcUserRepository.save(
                R2dbcUserEntity
                        .builder()
                        .id(user.getId().toString())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build()
        ).thenReturn(user);
    }
}
