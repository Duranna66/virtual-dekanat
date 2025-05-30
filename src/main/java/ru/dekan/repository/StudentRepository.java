package ru.dekan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dekan.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUserId(Long userId);
}