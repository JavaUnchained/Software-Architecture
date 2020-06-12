package com.example.foodeliver.entity.users;

import com.example.foodeliver.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends User {

    public Client(String surname, String name, String phoneNumber, String username, String password, Role roleId, Account account) {
        super(surname, name, phoneNumber, username, password, roleId);
        this.account = account;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;
}
