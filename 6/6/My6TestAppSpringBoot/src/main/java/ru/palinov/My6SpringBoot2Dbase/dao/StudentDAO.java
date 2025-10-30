package ru.palinov.My6SpringBoot2Dbase.dao;

import ru.palinov.My6SpringBoot2Dbase.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO
{
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
