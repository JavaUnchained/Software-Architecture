package com.example.foodeliver.entity.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role roleId;

    public User(@NotNull final String surname, @NotNull final String name, @NotNull final String phoneNumber,
                @NotNull final String username, @NotNull final String password, @NotNull final Role roleId) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }
}