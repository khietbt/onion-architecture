package io.github.khietbt.infrastructure.database.r2dbc.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.services.DomainUserService;
import io.github.khietbt.infrastructure.database.r2dbc.entities.R2dbcUserEntity;
import io.github.khietbt.infrastructure.database.r2dbc.repositories.R2dbcUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
@Primary
public class R2dbcUserService implements DomainUserService {
    private final R2dbcUserRepository r2dbcUserRepository;

    public R2dbcUserService(R2dbcUserRepository r2dbcUserRepository) {
        this.r2dbcUserRepository = r2dbcUserRepository;
    }

    @Override
    public DomainUserEntity findById(UUID id) throws Exception {
        return this.r2dbcUserRepository
                .getOneById(id.toString())
                .map(
                        (r) -> DomainUserEntity
                                .builder()
                                .id(UUID.fromString(r.getId()))
                                .name(r.getName())
                                .email(r.getEmail())
                                .build()
                )
                .toFuture()
                .get();
    }

    @Override
    public void create(DomainUserEntity user) throws RuntimeException, ExecutionException, InterruptedException {
        this.r2dbcUserRepository.save(
                R2dbcUserEntity
                        .builder()
                        .id(user.getId().toString())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build()
        ).toFuture().get();
    }
}
