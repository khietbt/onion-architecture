package io.github.khietbt.domain.entities;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class DomainPostEntity {
    private UUID id;

    private String title;

    private String content;
}
