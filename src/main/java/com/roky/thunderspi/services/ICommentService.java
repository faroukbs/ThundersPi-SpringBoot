package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.Post;
import com.roky.thunderspi.entities.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> retrieveAllCommentaires();

  Comment addCommentaire(Comment c);

    void deleteCommentaire(Long id);
    Comment updateCommentaire(Comment u);
    Comment retrieveCommentaire(Long id);
}
