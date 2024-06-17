package io.github.khietbt.domain.entities;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class DomainUserEntity {
    private UUID id;

    private String name;

    private String email;
}
