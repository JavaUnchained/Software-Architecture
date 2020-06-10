package com.example.foodeliver.entity;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "USER_TYPE")
@Table(name = "USERS")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
