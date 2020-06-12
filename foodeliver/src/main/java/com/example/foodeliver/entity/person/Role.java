package com.example.foodeliver.entity.person;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }
}

//
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "t_role")
//@Data
//@NoArgsConstructor
//public class Role implements GrantedAuthority {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", unique = true, nullable = false)
//    private String name;
//
//    public Role(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    @Transient
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;
//
//    public Role(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String getAuthority() {
//        return getName();
//    }
//}
