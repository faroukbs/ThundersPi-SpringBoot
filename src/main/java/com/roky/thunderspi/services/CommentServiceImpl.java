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
    public void add(Comment s) {
        commentRepo.save(s);
    }

    @Override
    public Comment update(Comment s) {
        return commentRepo.save(s);
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public Comment getById(long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {

        commentRepo.deleteById(id);
    }
}
