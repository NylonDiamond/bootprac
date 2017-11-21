package com.questionmarks.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data // bundles the features of @ToString, @EqualsAndHashCode, @Getter, @Setter and @RequiredArgsConstructor together.
@Entity //mark this class as an entity that will be managed by JPA/Hibernate.
public class Exam {
    @Id //indicate that the id property is the primary key of this entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indicate that the primary key value will be assigned by the persistence provider (i.e. PostgreSQL).
    private long id;

    @NotNull //to avoid persisting empty data for these fields.
    private String title;

    @NotNull
    private String description;

//    @NotNull
//    private LocalDateTime createdAt;
//
//    @NotNull
//    private LocalDateTime editedAt;
//
//    @NotNull
//    private boolean published;
}