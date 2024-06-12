package io.github.khietbt.infrastructures.cached.entities;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class CachedUser {
    private UUID id;

    private String name;

    private String email;

    private Date cachedAt;
}
