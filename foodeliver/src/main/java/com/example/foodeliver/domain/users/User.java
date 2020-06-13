package com.example.foodeliver.domain.users;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String surname;

    private String name;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    private String password;

    public User(String surname, String name, String phoneNumber, String username, String password, Role roleId) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role roleId;

}