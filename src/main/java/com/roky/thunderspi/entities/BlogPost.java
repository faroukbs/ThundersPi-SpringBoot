package com.roky.thunderspi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPost;
    String title;
    String content;
    String picture;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Actuality actuality;

    @OneToMany(mappedBy = "blogPost",cascade = CascadeType.REMOVE)
    private Set<Comment> comments;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

}
