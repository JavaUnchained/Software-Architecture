package com.example.foodeliver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "USER_ROLE")
@Table(name = "USR")
@Data
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
