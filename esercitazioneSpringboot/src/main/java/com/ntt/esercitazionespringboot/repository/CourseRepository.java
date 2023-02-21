package com.ntt.esercitazionespringboot.repository;

import com.ntt.esercitazionespringboot.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}