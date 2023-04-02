package com.tiva.event.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class CommentLikeId implements Serializable {

    private Long postId;

    private Long userId;

    private Long commentId;
}
