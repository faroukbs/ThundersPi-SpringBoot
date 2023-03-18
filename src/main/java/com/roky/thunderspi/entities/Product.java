package com.roky.thunderspi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduct;
    String name;
    String description;
    BigDecimal price;
    int quantity;
    String picture;
    LocalDate createdDate;
    LocalDate updatedDate;

    @JsonBackReference
    @ManyToOne
    CategoryProduct category;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "image", fetch = FetchType.EAGER)
    Set<MultiPicture> products;


    @JsonIgnore
    @ManyToMany
    Set<User> whoWhishesThisProduct;



    Double etoile;
    @ElementCollection
    Map<Long, Double> clientEtoile;
}
