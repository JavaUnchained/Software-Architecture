package com.example.foodeliver.model.entity.users;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
public class Courier extends User {

    public Courier(@NotNull final String surname, @NotNull final String name, @NotNull final String phoneNumber,
                   @NotNull final String username, @NotNull final String password, @NotNull final Role roleId) {
        super(surname, name, phoneNumber, username, password, roleId);
    }

}
