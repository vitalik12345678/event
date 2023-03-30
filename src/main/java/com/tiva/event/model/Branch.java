package com.tiva.event.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "branch",schema = "public")
@NoArgsConstructor
public class Branch {
    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @OneToMany(mappedBy = "branch")
    private List<Post> posts;
}
