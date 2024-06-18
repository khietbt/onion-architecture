package io.github.khietbt.application.services;

import io.github.khietbt.domain.entities.DomainUserEntity;
import io.github.khietbt.domain.repositories.DomainUserRepository;
import io.github.khietbt.domain.services.DomainUserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationUserService implements DomainUserService {
    private final DomainUserRepository domainUserRepository;

    public ApplicationUserService(DomainUserRepository domainUserRepository) {
        this.domainUserRepository = domainUserRepository;
    }

    @Override
    public DomainUserEntity findById(UUID id) throws RuntimeException {
        return domainUserRepository
                .getOneById(id)
                .orElseThrow(
                        () -> new RuntimeException("Could not find domain user with id: " + id)
                );
    }

    @Override
    public void create(DomainUserEntity user) throws RuntimeException {
        domainUserRepository.create(user);
    }
}
