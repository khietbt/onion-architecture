package io.github.khietbt.presentation.api.webflux.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UserCreateResponse {
    private UUID id;

    private String name;

    private String email;
}