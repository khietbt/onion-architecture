package io.github.khietbt.infrastructure.inmemory.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class InMemoryUserEntity {
    private UUID id;

    private String name;

    private String email;

    private Date cachedAt;
}
