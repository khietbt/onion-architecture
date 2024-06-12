package io.github.khietbt.domains.repositories;

import io.github.khietbt.domains.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
}
