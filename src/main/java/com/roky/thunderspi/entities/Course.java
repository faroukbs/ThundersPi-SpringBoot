package com.roky.thunderspi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCourse ;
    String name;
    String educationLevel;
    String length;
    LocalDate dateAdded;
    LocalDate dateUpdated;
    String courseLanguage;

    @OneToMany(mappedBy = "course", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    private Set<Project> projects = new LinkedHashSet<>();

}
