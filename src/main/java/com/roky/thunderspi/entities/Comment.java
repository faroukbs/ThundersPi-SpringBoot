package com.roky.thunderspi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    @Column(columnDefinition = "text")
    private String content;

    @OneToOne
    private User user;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    @Column(nullable = true)
    private Date deleted_at;

    @ManyToOne
    @JsonBackReference
    private Post postcom;


    public Comment() {
    }

    public Comment(String content, User user, Post post) {
        this.content = content;
        this.user = user;
        this.postcom = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return postcom;
    }

    public void setPost(Post post) {
        this.postcom = post;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() &&
                Objects.equals(getContent(), comment.getContent()) &&
                Objects.equals(getUser(), comment.getUser()) &&
                Objects.equals(getPost(), comment.getPost());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getContent(), getUser(), getPost());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", post=" + postcom +
                '}';
    }
}
