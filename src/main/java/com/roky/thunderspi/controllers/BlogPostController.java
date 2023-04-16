package com.roky.thunderspi.controllers;

import com.roky.thunderspi.dto.PostDto;
import com.roky.thunderspi.entities.Post;
import com.roky.thunderspi.services.BlogPostServiceImpl;
import com.roky.thunderspi.services.IBlogPostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class BlogPostController {

    @Autowired
    private BlogPostServiceImpl postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto){

        postService.createPost(postDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts(){
        return new ResponseEntity<>(postService.showAllPosts(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id){

        return  new ResponseEntity<>(postService.readSinglePost(id),HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody Post post) {
        this.postService.savePost(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity destroy(@PathVariable Long id) {

        String msg = this.postService.deletePost(id);

        return new  ResponseEntity<>( null, HttpStatus.ACCEPTED);
    }
}