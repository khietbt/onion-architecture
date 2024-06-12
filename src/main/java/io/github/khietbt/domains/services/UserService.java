package io.github.khietbt.domains.services;

import io.github.khietbt.domains.entities.User;

import java.util.UUID;

public interface UserService {
    User getById(UUID id) throws Exception;
}