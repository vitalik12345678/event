package com.tiva.event.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "grade_post")
@IdClass(GradePostId.class)
public class GradePost {

    @Id
    @Column(name = "post_id", nullable = false)
    private Long postId;
    @Id
    @Column(nullable = false)
    private Long userId;

    @Column(name = "grade_value")
    @Range(min = 0, max = 5)
    private Short gradeValue;

}



