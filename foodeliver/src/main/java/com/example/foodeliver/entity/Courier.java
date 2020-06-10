package com.example.foodeliver.entity;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("COURIER")
public class Courier extends User {
}
