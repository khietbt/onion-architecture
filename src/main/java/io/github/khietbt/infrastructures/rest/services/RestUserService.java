package io.github.khietbt.infrastructures.rest.services;

import io.github.khietbt.domains.entities.User;
import io.github.khietbt.domains.services.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestUserService implements UserService {
    @Override
    public User getById(UUID id) throws Exception {
        // TODO:
        return null;
    }

    @Override
    public void create(User user) throws Exception {
        // TODO:
    }

    @Override
    public void update(User user) throws Exception {
        // TODO:
    }
}
