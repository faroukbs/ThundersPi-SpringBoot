package com.roky.thunderspi.services;

import com.roky.thunderspi.dto.PostDto;
import com.roky.thunderspi.entities.Post;

import java.util.List;

public interface IBlogPostService {

    void createPost(PostDto postDto);


    List<PostDto> showAllPosts();

    PostDto readSinglePost(Long id);

    String deletePost(long id);

    Post getSinglePost(Long id);


}
