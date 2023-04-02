package com.tiva.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment_like")
@NoArgsConstructor
@IdClass(CommentLikeId.class)
public class CommentLike {

    @Id
    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Id
    @Column(name = "comment_id", nullable = false)
    private Long commentId;

    @MapsId("post_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Post post;

    @MapsId("comment_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Comment comment;

}
