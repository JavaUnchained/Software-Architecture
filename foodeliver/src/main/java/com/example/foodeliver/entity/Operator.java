package com.example.foodeliver.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OPERATOR")
public class Operator extends User{

}
