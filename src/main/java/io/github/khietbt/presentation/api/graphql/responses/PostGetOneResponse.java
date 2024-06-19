package io.github.khietbt.presentation.api.graphql.responses;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class PostGetOneResponse {
    private String id;

    private String title;

    private String content;
}
