package com.roky.thunderspi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idCommentaire ;

     Long idClient;

     String comment;

     Long likes;
    @JsonBackReference
    @ManyToOne
     Product produit;

    @CreationTimestamp
     LocalDate dateCreated;


    @UpdateTimestamp
     LocalDate lastUpdated;
}
