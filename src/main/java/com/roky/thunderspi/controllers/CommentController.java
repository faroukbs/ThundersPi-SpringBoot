package com.roky.thunderspi.controllers;

import com.roky.thunderspi.dto.PostDto;
import com.roky.thunderspi.entities.Comment;
import com.roky.thunderspi.entities.Post;
import com.roky.thunderspi.entities.Product;
import com.roky.thunderspi.entities.ProductComment;
import com.roky.thunderspi.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommentController {

    private ICommentService commentaireService;
    private IBlogPostService iBlogPostService;
    private UserServiceImpl userService;

    @GetMapping("/getall")
    @ResponseBody
    public List<Comment> getAll() {
        List<Comment> comments = commentaireService.retrieveAllCommentaires();
        return comments;
    }
    public void add(@RequestBody Comment c) throws Exception {
        List<String> badWords = Collections.unmodifiableList(Arrays.asList("bob", "fuck", "shit", "dick", "sh*t", "ass", "bitch", "bastard", "cunt", "trash", "wanker", "piss", "pussy", "twat", "crap", "arsehole", "gash", "prick", "cock", "minge", "nigga", "slut", "damn", "sucker", "cracker", "poop", "puup", "boob", "buub", "f*ck", "b*tch", "3asba", "nayek", "nikomok", "9a7ba", "zebi", "sorm"));
        Post p = iBlogPostService.getSinglePost(c.getPost().getId());

        if (p == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "NULL");
        }


        if (c.getContent().replaceAll("\\s+", "").equals("")) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Empty");
        }

        for (String bW : badWords) {
            if (c.getContent().toLowerCase().replaceAll("\\s+", "").replaceAll("1", "i").replaceAll("!", "i").replaceAll("3", "e").replaceAll("4", "a").replaceAll("@", "a").replaceAll("5", "s").replaceAll("7", "t").replaceAll("0", "o").replaceAll("9", "g").contains(bW)) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Bad Boy");
            }
        }

        for (Comment com : p.getComments()) {
            if (c.getContent().equals(com.getContent())) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Duplicated");
            }
        }

    }

    @GetMapping("/retrieve-commentaire/{commentaire-id}")
    @ResponseBody
    public Comment retrieveCommentaire(@PathVariable("commentaire-id") Long commentaireId) {
        return commentaireService.retrieveCommentaire(commentaireId);
    }


    // http://localhost:8081/remove-commentaire/{commentaire-id}
    @DeleteMapping("/remove-client/{commentaire-id}")
    @ResponseBody
    public void removeCommentaire(@PathVariable("commentaire-id") Long commentaireId) {
        commentaireService.deleteCommentaire(commentaireId);
    }

    // http://localhost:8081/modify-commentaire
    @PutMapping("/modify-commentaire")
    @ResponseBody
    public Comment modifyClient(@RequestBody Comment c) throws Exception {
        List<String> badWords=Collections.unmodifiableList(Arrays.asList("bob","fuck","shit","dick","sh*t","ass","bitch","bastard","cunt","trash","wanker","piss","pussy","twat","crap","arsehole","gash","prick","cock","minge","nigga","slut","damn","sucker","cracker","poop","puup","boob","buub","f*ck","b*tch"));
        Post p=iBlogPostService.getSinglePost(c.getPostcom().getId());

        if(p==null){throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "NULL");}


        if(c.getContent().replaceAll("\\s+","").equals("")){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Empty");
        }

        for(String bW : badWords){
            if(c.getContent().toLowerCase().replaceAll("\\s+","").replaceAll("1", "i").replaceAll("!", "i").replaceAll("3", "e").replaceAll("4", "a").replaceAll("@", "a").replaceAll("5", "s").replaceAll("7", "t").replaceAll("0", "o").replaceAll("9", "g").contains(bW)){throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Bad Boy");}
        }

        for(Comment com :p.getComments()){
            if(c.getContent().equals(com.getContent()) ){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Duplicated");
            }
        }
        return commentaireService.updateCommentaire(c);
    }


}
