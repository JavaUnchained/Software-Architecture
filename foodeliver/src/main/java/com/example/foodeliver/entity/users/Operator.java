package com.example.foodeliver.entity.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "operator")
@Getter
@Setter
@NoArgsConstructor
public class Operator extends User {
    public Operator(String surname, String name, LocalDate dateOfBirth, String phoneNumber, String username, String password, Role roleId) {
        super(surname, name, dateOfBirth, phoneNumber, username, password, roleId);
    }
}
