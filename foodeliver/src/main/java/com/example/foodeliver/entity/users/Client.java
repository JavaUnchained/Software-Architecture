package com.example.foodeliver.entity.users;

import com.example.foodeliver.entity.Account;
import com.example.foodeliver.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public Client(@NotNull final String surname, @NotNull final String name,
                  @NotNull final String phoneNumber, @NotNull final String username,
                  @NotNull final String password, @NotNull final Role roleId, @NotNull final Account account) {
        super(surname, name, phoneNumber, username, password, roleId);
        this.account = account;
    }
}
