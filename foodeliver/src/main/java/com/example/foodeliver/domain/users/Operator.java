package com.example.foodeliver.domain.users;

import com.example.foodeliver.domain.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "operator")
@Getter @Setter
@NoArgsConstructor
public class Operator extends User {

    public Operator(String surname, String name, String phoneNumber, String username, String password, Role roleId, Account account) {
        super(surname, name, phoneNumber, username, password, roleId);
        this.account = account;
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operator", fetch = FetchType.EAGER)
//    private List<Coupon> orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;
}
