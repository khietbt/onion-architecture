package io.github.khietbt.infrastructures.cached.services;

import io.github.khietbt.domains.entities.User;
import io.github.khietbt.domains.repositories.UserRepository;
import io.github.khietbt.domains.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CachedUserService implements UserService {
    private final UserRepository userRepository;

    public CachedUserService(@Qualifier("cachedUserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(UUID id) throws Exception {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the user (id=" + id + ") from the cache"));
    }

    @Override
    public void create(User user) throws Exception {
        this.userRepository.create(user);
    }

    @Override
    public void update(User user) throws Exception {
        this.userRepository.update(user);
    }
}
