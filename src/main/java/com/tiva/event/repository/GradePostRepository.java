package com.tiva.event.repository;

import com.tiva.event.model.GradePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradePostRepository extends JpaRepository<GradePost, Long> {
}
