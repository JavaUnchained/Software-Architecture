package com.example.foodeliver.entity.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "courier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier extends User {

    public Courier(String surname, String name, String phoneNumber,
                   String username, String password, Role roleId) {
        super(surname, name, phoneNumber, username, password, roleId);
    }

}
