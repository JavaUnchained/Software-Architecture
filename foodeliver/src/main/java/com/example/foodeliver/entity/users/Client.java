package com.example.foodeliver.entity.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends User {

    public Client(String surname, String name, String phoneNumber, String username, String password, Role roleId) {
        super(surname, name, phoneNumber, username, password, roleId);
    }

}
