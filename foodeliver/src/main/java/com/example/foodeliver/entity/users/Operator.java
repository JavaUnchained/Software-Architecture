package com.example.foodeliver.entity.users;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operator")
@Data
@NoArgsConstructor
public class Operator extends User {
    public Operator(String surname, String name, String phoneNumber, String username, String password, Role roleId) {
        super(surname, name, phoneNumber, username, password, roleId);
    }
}
