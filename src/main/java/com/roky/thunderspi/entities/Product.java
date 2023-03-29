package com.roky.thunderspi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
     Long id;

     String name;

     String description;

     BigDecimal prix;

     int quantity;

     String picture;

    @CreationTimestamp
     LocalDate createdDate;

    @UpdateTimestamp
     LocalDate updatedDate;

    @JsonBackReference
    @ManyToOne
     CategoryProduct category ;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "image", fetch = FetchType.EAGER)
     Set<MultiPicture> products;


    @JsonIgnore
    @ManyToMany
     Set<User> whoWhishesThisProduct;


    @JsonManagedReference
    @OneToMany(cascade=CascadeType.PERSIST,mappedBy = "produit",fetch=FetchType.LAZY)
     List<ProductComment> commentaire;

     Double etoile;
    @ElementCollection
     Map<Long, Double> clientEtoile;

}
