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
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column(name = "creation_date")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "status_enum")
    @Type(PostgreSQLEnumType.class)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "event_type_enum")
    @Type(PostgreSQLEnumType.class)
    private EventTypeEnum event;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "format_enum")
    @Type(PostgreSQLEnumType.class)
    private FormatEnum format;

    @ManyToOne()
    @JoinColumn(name = "created_by")
    @CreatedBy
    private User createdBy;

    @ManyToOne()
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

}
