package com.tiva.event.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class CommentLike implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", nullable = false )
    private Post postId;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id")
    private Comment commentId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user) {
        this.userId = user;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post post) {
        this.postId = post;
    }

    public Comment getCommentId() {
        return commentId;
    }

    public void setCommentId(Comment comment) {
        this.commentId = comment;
    }
}
