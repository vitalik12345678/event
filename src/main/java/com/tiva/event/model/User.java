package com.tiva.event.model;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.tiva.event.model.enumConverters.RoleConverter;
//import com.tiva.event.model.enumConverters.RoleConverter;
import com.tiva.event.model.enumConverters.RoleConverter;
import com.tiva.event.model.enums.RoleEnum;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "role_enum")
    @Convert(converter = RoleConverter.class)
    @Type(PostgreSQLEnumType.class)
    private RoleEnum role;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM--dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM--dd HH:mm:ss")
    private LocalDateTime lastVisitedAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM--dd HH:mm:ss")
    private LocalDateTime blockedAt;
    private boolean isBlocked;

    public User() {
    }

}
