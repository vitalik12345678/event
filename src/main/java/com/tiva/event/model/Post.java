package com.tiva.event.model;

import com.tiva.event.model.enums.EventTypeEnum;
import com.tiva.event.model.enums.FormatEnum;
import com.tiva.event.model.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(name = "creation_date")
    private final LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    @Enumerated(value = EnumType.STRING)
    private StatusEnum status = StatusEnum.WAITING;

    @Enumerated(value = EnumType.STRING)
    private EventTypeEnum event = EventTypeEnum.OTHER;

    @Enumerated(value = EnumType.STRING)
    private FormatEnum format = FormatEnum.UNSPECIFIED;

    @ManyToOne()
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne()
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

}
