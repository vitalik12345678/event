package com.tiva.event.service;

import com.tiva.event.model.*;
import com.tiva.event.repository.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final PostRepository postRepository;
    private final BranchRepository branchRepository;
    private final UserRepository userRepository;
    private final GradePostRepository gradePostRepository;
    private final CommentRepository commentRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(new Post());
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public User createUser(User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public GradePost createGradePost(GradePost gradePost) {

        return gradePostRepository.save(gradePost);

    }

    public List<GradePost> getGrades() {
       return gradePostRepository.findAll();
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
