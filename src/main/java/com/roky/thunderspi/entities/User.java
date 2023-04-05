package com.roky.thunderspi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;
    String FirstName;
    String LastName;
    String phone_number;
    LocalDate date_inscription;
    String email;
    String password;
    String state;
    Role role;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public void add(Order order) {

        if (order != null) {

            if (orders == null) {
                orders = new HashSet<>();
            }

            orders.add(order);
            order.setCustomer(this);
        }
    }

    @ManyToMany(mappedBy = "whoWhishesThisProduct")
    public Set<Product> productsWished;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private Set<BlogPost> blogPosts;
}
