package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.Comment;
import com.roky.thunderspi.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService{

    @Autowired
    CommentRepo commentRepo;

    @Override
    public List<Comment> retrieveAllCommentaires() {
        List<Comment> commentaires = (List<Comment>) commentRepo.findAll();

        return commentaires;
    }

    @Override
    public Comment addCommentaire(Comment c) {
        commentRepo.save(c);
        return c;
    }

    @Override
    public void deleteCommentaire(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public Comment updateCommentaire(Comment u) {
        commentRepo.save(u);
        return u;
    }

    @Override
    public Comment retrieveCommentaire(Long id) {
      Comment commentaire = commentRepo.findById(id).orElse(null);
        return commentaire;
    }
}
