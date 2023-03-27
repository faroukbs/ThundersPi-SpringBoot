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
    private Long id;

    private String name;

    private String description;

    private BigDecimal prix;

    private int quantity;

    private String picture;

    @CreationTimestamp
    private LocalDate createdDate;

    @UpdateTimestamp
    private LocalDate updatedDate;

    @JsonBackReference
    @ManyToOne
    private CategoryProduct category ;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "image", fetch = FetchType.EAGER)
    private Set<MultiPicture> products;


    @JsonIgnore
    @ManyToMany
    private Set<User> whoWhishesThisProduct;


    @JsonManagedReference
    @OneToMany(cascade=CascadeType.PERSIST,mappedBy = "produit",fetch=FetchType.LAZY)
    private List<ProductComment> commentaire;

    private Double etoile;
    @ElementCollection
    private Map<Long, Double> clientEtoile;

}
