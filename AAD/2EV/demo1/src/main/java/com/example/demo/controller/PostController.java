package com.example.demo.controller;

import com.example.demo.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.PostRepository;

import java.util.List;

@RestController
public class PostController {


    private final PostRepository postRepository;


    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Post savePost(@RequestBody Post p){
        return postRepository.save(p);
    }






}
