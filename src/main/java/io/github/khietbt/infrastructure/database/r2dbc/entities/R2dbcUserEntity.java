package io.github.khietbt.infrastructure.database.r2dbc.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@ToString
public class R2dbcUserEntity extends R2dbcEntity {
    private String name;

    private String email;
}
