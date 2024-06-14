package io.github.khietbt.infrastructures.cached.repositories;

import io.github.khietbt.domains.entities.User;
import io.github.khietbt.domains.repositories.UserRepository;
import io.github.khietbt.infrastructures.cached.entities.CachedUser;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CachedUserRepository implements UserRepository {
    private final Map<UUID, CachedUser> cachedUsers = new HashMap<>();

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(cachedUsers.get(id))
                .map(
                        (u) -> User
                                .builder()
                                .id(u.getId())
                                .name(u.getName())
                                .email(u.getEmail())
                                .build()
                );
    }

    @Override
    public UUID create(User user) {
        assert user.getId() != null;

        this.cachedUsers.put(
                user.getId(),
                CachedUser
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .cachedAt(new Date())
                .build()
        );

        return user.getId();
    }

    @Override
    public void update(User user) {
        assert user.getId() != null;

        this.cachedUsers.put(
                user.getId(),
                CachedUser
                        .builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .cachedAt(new Date())
                        .build()
        );
    }
}
