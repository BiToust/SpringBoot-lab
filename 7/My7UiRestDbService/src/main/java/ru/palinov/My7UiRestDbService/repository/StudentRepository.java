package ru.palinov.My7UIRestDbService.repository;

import ru.palinov.My7UIRestDbService.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}