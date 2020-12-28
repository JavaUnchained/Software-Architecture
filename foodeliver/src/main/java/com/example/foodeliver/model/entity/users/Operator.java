package com.example.foodeliver.model.entity.users;

import com.example.foodeliver.model.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Operator extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Operator(@NotNull final String surname, @NotNull final String name,
                    @NotNull final String phoneNumber, @NotNull final String username,
                    @NotNull final String password, @NotNull final Role roleId, @NotNull final Account account) {
        super(surname, name, phoneNumber, username, password, roleId);
        this.account = account;
    }
}
