package com.roky.thunderspi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @Lob // it means data can take up a lot of space
    @Column
    @NotEmpty
    private String content;


    private String image;

    @Column
    private Instant created_At;

    @Column
    private Instant updated_At;

    @Column(nullable = true)
    private Date deleted_at;

    @ManyToOne
    private User user;

    @Column
    @NotBlank
    private String userName;
    @OneToMany(mappedBy = "postcom")
    private List<Comment> comments = new ArrayList<Comment>();

    public List<Comment> getComments() {
        return comments;
    }

    public Post() {
    }

    public Post(String title, String content, String image, User user) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.user = user;
    }
}
