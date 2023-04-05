package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.BlogPost;
import com.roky.thunderspi.entities.Comment;

import java.util.List;

public interface ICommentService {

    void add(Comment s);

    Comment update(Comment s);

    List<Comment> getAll();

    Comment getById(long id);

    void remove(long id);
}
