package com.roky.thunderspi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     Long id;

     String imageUrl;

     BigDecimal prix;

     int quantity;

     Long productId;

    @ManyToOne
     Order order;

}
