package io.github.khietbt.application.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.repositories.DomainUserRepository;
import io.github.khietbt.domain.services.DomainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationUserService implements DomainUserService {
    @Autowired
    private DomainUserRepository domainUserRepository;

    @Override
    public DomainUserEntity findById(UUID id) throws RuntimeException {
        return domainUserRepository
                .getById(id)
                .orElseThrow(
                        () -> new RuntimeException("Could not find domain user with id: " + id)
                );
    }
}
