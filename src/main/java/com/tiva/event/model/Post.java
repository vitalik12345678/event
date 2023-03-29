package com.tiva.event.model;

import com.tiva.event.model.enums.EventTypeEnum;
import com.tiva.event.model.enums.FormatEnum;
import com.tiva.event.model.enums.StatusEnum;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "status_enum")
    @Type(PostgreSQLEnumType.class)
    private StatusEnum status = StatusEnum.waiting;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "event_type_enum")
    @Type(PostgreSQLEnumType.class)
    private EventTypeEnum event = EventTypeEnum.other;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "format_enum")
    @Type(PostgreSQLEnumType.class)
    private FormatEnum format = FormatEnum.unspecified;

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
