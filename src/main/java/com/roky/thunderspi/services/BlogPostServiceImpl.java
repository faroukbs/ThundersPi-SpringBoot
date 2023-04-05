package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.BlogPost;
import com.roky.thunderspi.repositories.BlogPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostServiceImpl implements IBlogPostService {

    @Autowired
    BlogPostRepo blogPostRepo;


    @Override
    public void add(BlogPost s) {
        blogPostRepo.save(s);
    }

    @Override
    public BlogPost update(BlogPost s) {
        return blogPostRepo.save(s);
    }

    @Override
    public List<BlogPost> getAll() {
        return (List<BlogPost>) blogPostRepo.findAll();
    }

    @Override
    public BlogPost getById(long id) {
        return blogPostRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {

        blogPostRepo.deleteById(id);
    }
}
