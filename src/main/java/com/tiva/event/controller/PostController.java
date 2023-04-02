package com.tiva.event.controller;

import com.tiva.event.model.Comment;
import com.tiva.event.model.GradePost;
import com.tiva.event.model.Post;
import com.tiva.event.model.User;
import com.tiva.event.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController {

    private final Service service;


    @GetMapping("/post")
    public List<Post> getAll() {
        return service.getAllPosts();
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return service.getPost(id);
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return service.createPost(post);
    }

    @PostMapping("/user")
    public User createUsers(@RequestBody User user) {
        return service.createUser(user);
    }
    @GetMapping("/user")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/grade-post")
    public GradePost createGradePost(@RequestBody GradePost gradePost) {
       return service.createGradePost(gradePost);
    }

    @GetMapping("/grade-post")
    public List<GradePost> getGrades() {
        return service.getGrades();
    }

    @GetMapping("/comment")
    public List<Comment> getComments() {
        return service.getComments();
    }

    @PostMapping("/comment")
    public Comment createComment(@RequestBody Comment comment) {
        return service.createComment(comment);
    }



}
