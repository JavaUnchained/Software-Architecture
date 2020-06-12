package com.example.foodeliver.entity.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "courier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier extends User {

    public Courier(String surname, String name, LocalDate dateOfBirth, String phoneNumber, String username, String password, Role roleId, String status, String category) {
        super(surname, name, dateOfBirth, phoneNumber, username, password, roleId);
        this.status = status;
        this.category = category;
    }


    @Column(name = "status")
    private String status;

    @Column(name = "category")
    private String category;

}
