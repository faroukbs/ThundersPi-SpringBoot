package com.roky.thunderspi.controllers;

import com.roky.thunderspi.entities.BlogPost;
import com.roky.thunderspi.services.IBlogPostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogPostController {

    @Autowired
    private IBlogPostService iBlogPostService;

    @PostMapping
    void add(@RequestBody BlogPost s) {
        iBlogPostService.add(s);
    }

    @PutMapping("/update")
    BlogPost update(@RequestBody BlogPost s){
        return iBlogPostService.update(s);
    }

    @GetMapping
    List<BlogPost> getAll() {
        return iBlogPostService.getAll();
    }

    @GetMapping("/{id}")
    BlogPost getById(@PathVariable long id)
    {
       return iBlogPostService.getById(id);
    }
    @DeleteMapping("/{id}")
    void remove(@PathVariable long id)
    {
        iBlogPostService.remove(id);
    }

}
