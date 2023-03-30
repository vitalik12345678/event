package com.tiva.event.model;

import com.tiva.event.model.enums.RoleEnum;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Long phone;

    @CreatedDate
    @Column
    private LocalDateTime creationDate;

    @Column
    @LastModifiedDate
    private LocalDateTime lastVisitedDate;

    @Column
    @LastModifiedDate
    private LocalDateTime blockedDate;

    @Type(PostgreSQLEnumType.class)
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "role_enum")
    private RoleEnum role;

    @OneToMany(mappedBy = "createdBy")
    private List<Comment> commentList;

}
