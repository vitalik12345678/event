package com.tiva.event.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "comment")
@Entity
@Getter
@Setter

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    @DateTimeFormat()
    private Long commentId;

    @Column(name = "message")
    private String message;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "blocked_date")
    private LocalDateTime blockedDate;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> childCommentList;

    //@CreatedBy
    @Fetch(FetchMode.SUBSELECT)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by",referencedColumnName = "user_id")
    private User createdBy;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",referencedColumnName = "post_id")
    private Post post;
}
