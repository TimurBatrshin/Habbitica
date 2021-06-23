package com.simbirsoft.habbitica.impl.models.data;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "tasks")
    private Set<User> users;

    private String title;
    private String description;
}