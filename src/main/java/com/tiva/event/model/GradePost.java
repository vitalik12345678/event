package com.tiva.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class GradePost {

    @EmbeddedId
    private GradePostId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    @JsonIgnore()
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore()
    private User user;

    @Column(name = "grade_value")
    @Range(min = 0, max = 5)
    private Short gradeValue;

}



