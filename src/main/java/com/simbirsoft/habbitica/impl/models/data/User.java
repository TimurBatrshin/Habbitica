package com.simbirsoft.habbitica.impl.models.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String hashPassword;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"))
    private Set<Task> tasks;

    @ManyToMany
    @JoinTable(name="subscription",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="subscriber_id", referencedColumnName = "id"))
    private Set<User> subscribers;

    @ManyToMany
    @JoinTable(name="subscription",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="subscriber_id", referencedColumnName = "id"))
    private Set<User> subscriptions;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
