package com.example.foodeliver.entity.users;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cook")
@Data
@NoArgsConstructor
public class Cook extends User {

    public Cook(String surname, String name, String phoneNumber, String username, String password, Role roleId) {
        super(surname, name, phoneNumber, username, password, roleId);
    }

}
