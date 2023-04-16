package com.roky.thunderspi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Actuality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idActuality;

    @OneToMany(mappedBy = "actuality", cascade = CascadeType.REMOVE)
    private Set<Post> blogPostset;
}
