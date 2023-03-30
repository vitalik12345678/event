package com.tiva.event.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment_like")
public class CommentLike {

    @EmbeddedId
    private CommentLikeId commentLikeId;

}
