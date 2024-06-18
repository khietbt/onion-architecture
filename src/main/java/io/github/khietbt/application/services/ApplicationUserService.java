package io.github.khietbt.application.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.services.DomainUserService;
import io.github.khietbt.infrastructure.database.r2dbc.services.R2dbcUserService;
import io.github.khietbt.infrastructure.inmemory.services.InMemoryUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ApplicationUserService implements DomainUserService {
    private final DomainUserService inMemoryUserService;
    private final DomainUserService databaseUserService;

    public ApplicationUserService(
            InMemoryUserService inMemoryUserService,
            R2dbcUserService databaseUserService
    ) {
        this.inMemoryUserService = inMemoryUserService;
        this.databaseUserService = databaseUserService;
    }

    @Override
    public DomainUserEntity findById(UUID id) throws Exception {
        try {
            return this.inMemoryUserService.findById(id);
        } catch (Exception e) {
            log.error("Could not find user with id {} in the cache, searching the database", id);

            var user = this.databaseUserService.findById(id);

            log.error("Found user with id {} in the database, placing it into the cache", id);
            this.inMemoryUserService.create(user);

            return user;
        }
    }

    @Override
    public void create(DomainUserEntity user) throws Exception {
        this.databaseUserService.create(user);
        // TODO: Trigger an event here
    }
}
