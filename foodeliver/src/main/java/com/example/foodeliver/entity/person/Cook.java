package com.example.foodeliver.entity.person;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cook")
@Data
@NoArgsConstructor
public class Cook extends User {
    public Cook(String surname, String name, LocalDate dateOfBirth, String phoneNumber, String username, String password, Role roleId) {
        super(surname, name, dateOfBirth, phoneNumber, username, password, roleId);
    }
}
