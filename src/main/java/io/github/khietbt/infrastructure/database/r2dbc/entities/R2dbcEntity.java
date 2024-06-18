package io.github.khietbt.infrastructure.database.r2dbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@Table(name = "users")
@ToString
public class R2dbcEntity {
    @Id
    private String id;

    @CreatedBy
    @Column("created_by")
    private String createdBy;

    @CreatedDate
    @Column("created_at")
    private Instant createdAt;

    @LastModifiedBy
    @Column("updated_by")
    private String updatedBy;

    @LastModifiedDate
    @Column("updated_at")
    private Instant updatedAt;

    @Version
    private int version;
}
