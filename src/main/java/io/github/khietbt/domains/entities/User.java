package io.github.khietbt.domains.entities;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class User {
    private UUID id;

    private String name;

    private String email;
}
