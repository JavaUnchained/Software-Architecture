package com.example.foodeliver.entity.person;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
