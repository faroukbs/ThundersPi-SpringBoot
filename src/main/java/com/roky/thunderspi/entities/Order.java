package com.roky.thunderspi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
     Long id;

     String orderTrackingNumber;

     int totalQuantity;

     BigDecimal totalPrice;

     String status;

    @CreationTimestamp
     LocalDate dateCreated;

    @UpdateTimestamp
     LocalDate lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
     Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
     User customer;



    public void add(OrderItem item) {

        if (item != null) {
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }

            orderItems.add(item);
            item.setOrder(this);
        }
    }
}
