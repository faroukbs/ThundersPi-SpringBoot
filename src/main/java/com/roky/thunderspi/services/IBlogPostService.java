package com.roky.thunderspi.services;

import com.roky.thunderspi.entities.BlogPost;

import java.util.List;

public interface IBlogPostService {

    void add(BlogPost s);

    BlogPost update(BlogPost s);

    List<BlogPost> getAll();

    BlogPost getById(long id);

    void remove(long id);
}
