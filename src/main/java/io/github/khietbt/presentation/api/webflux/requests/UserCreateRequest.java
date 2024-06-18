package io.github.khietbt.presentation.api.webflux.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UserCreateRequest {
    private String name;

    private String email;
}