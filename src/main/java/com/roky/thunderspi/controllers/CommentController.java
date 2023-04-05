package com.roky.thunderspi.controllers;

import com.roky.thunderspi.entities.Comment;
import com.roky.thunderspi.services.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class CommentController {

    private ICommentService iCommentService;
    private IBlogPostService iBlogPostService;
    private IUserService userService;

    @GetMapping("/getall")
    @ResponseBody
    public List<Comment> getAll() {
        List<Comment> comments = iCommentService.getAll();
        return comments;
    }
    public void add(Comment s){

    }
}
