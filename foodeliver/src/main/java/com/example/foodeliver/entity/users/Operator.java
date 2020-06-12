package com.example.foodeliver.entity.users;

import com.example.foodeliver.entity.Account;
import com.example.foodeliver.entity.Coupon;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operator")
@Data
@NoArgsConstructor
public class Operator extends User {

    public Operator(String surname, String name, String phoneNumber, String username, String password, Role roleId, Account account) {
        super(surname, name, phoneNumber, username, password, roleId);
        this.account = account;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operator", fetch = FetchType.EAGER)
    private List<Coupon> orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;
}
