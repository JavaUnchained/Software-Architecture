package com.example.foodeliver.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COOCK")
public class Cook extends User {
}
