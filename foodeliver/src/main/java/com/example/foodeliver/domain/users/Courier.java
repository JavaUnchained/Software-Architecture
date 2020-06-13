package com.example.foodeliver.domain.users;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "courier")
@NoArgsConstructor
public class Courier extends User {

    public Courier(String surname, String name, String phoneNumber,
                   String username, String password, Role roleId) {
        super(surname, name, phoneNumber, username, password, roleId);
    }

}
