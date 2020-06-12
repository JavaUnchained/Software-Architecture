package com.example.foodeliver.entity.users;

import com.example.foodeliver.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "operator")
@Data
@NoArgsConstructor
public class Operator extends User {

    public Operator(String surname, String name, String phoneNumber, String username, String password, Role roleId, Account account) {
        super(surname, name, phoneNumber, username, password, roleId);
        this.account = account;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;
}
