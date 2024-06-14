package io.github.khietbt.infrastructures.rest.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UserCreationRequest {
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "email", required = true)
    private String email;
}
