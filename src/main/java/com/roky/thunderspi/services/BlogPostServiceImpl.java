package com.roky.thunderspi.services;

import com.roky.thunderspi.dto.PostDto;
import com.roky.thunderspi.entities.Post;
import com.roky.thunderspi.exception.PostNotFoundException;
import com.roky.thunderspi.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BlogPostServiceImpl implements IBlogPostService {


    @Autowired
    private PostRepo postRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public void createPost(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User userName =  authenticationService.getCurrentUser().orElseThrow(
                ()->new IllegalArgumentException("No user logged in"));
        post.setUserName(userName.getUsername());
        post.setCreated_At(Instant.now());

        postRepository.save(post);

    }

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());

    }

    @Override
    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id" + id));


        return mapFromPostToDto(post);
    }


    @Override
    public String deletePost(long id) {
        return null;
    }

    @Override
    public Post getSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id" + id));


        return post;
    }

    private PostDto mapFromPostToDto(Post post) {

        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUserName(post.getUserName());

        return postDto;
    }


    private Post mapFromPostDtoToPost(PostDto postDto){

        Post post =  new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authenticationService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User not found"));
        post.setCreated_At(Instant.now());
        post.setUserName(loggedInUser.getUsername());
        post.setUpdated_At(Instant.now());

        return post;


    }

    public Post getPost(Long id) {
        return this.postRepository.findById(id).orElse(null);
    }
    public Post savePost(Post post) {
        return this.postRepository.save(post);
    }

    public String deletePost(Long id) {
        Post post = this.getPost(id);
        post.setDeleted_at(new Date());
        this.savePost(post);
        return new String("Post deleted");
    }
}
