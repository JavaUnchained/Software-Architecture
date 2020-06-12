//package com.example.foodeliver.service;
//
//import com.example.foodeliver.entity.person.Role;
//import com.example.foodeliver.entity.person.User;
//import com.example.foodeliver.repository.RoleRepository;
//import com.example.foodeliver.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService implements UserDetailsService {
//    @PersistenceContext
//    private EntityManager em;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return user;
//    }
//
//    public User findUserById(Long userId) {
//        Optional<User> userFromDb = userRepository.findById(userId);
//        return userFromDb.orElse(new User());
//    }
//
//    public List<User> allUsers() {
//        List<User> list = new ArrayList<>();
//        userRepository.findAll().iterator().forEachRemaining(list::add);
//        return list;
//    }
//
//    public boolean saveUser(User user) {
//        User userFromDB = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword(user.getPassword());
//        userRepository.save(user);
//        return true;
//    }
//
//    public boolean deleteUser(Long userId) {
//        if (userRepository.findById(userId).isPresent()) {
//            userRepository.deleteById(userId);
//            return true;
//        }
//        return false;
//    }
//
//    public List<User> usergtList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
//}
//
