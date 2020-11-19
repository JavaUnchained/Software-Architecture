package com.example.foodeliver.entity.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cook")
@Data
@NoArgsConstructor
public class Cook extends User {

    public Cook(@NotNull final String surname, @NotNull final String name, @NotNull final String phoneNumber,
                @NotNull final String username, @NotNull final String password, @NotNull final Role roleId) {
        super(surname, name, phoneNumber, username, password, roleId);
    }

}
