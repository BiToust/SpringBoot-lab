package ru.palinov.My6SpringBoot2Dbase.service;

import lombok.extern.slf4j.Slf4j;
import ru.palinov.My6SpringBoot2Dbase.dao.StudentDAO;
import ru.palinov.My6SpringBoot2Dbase.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents()
    {
        log.info("Вывод успешен");
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public ResponseEntity<Student>  saveStudent(Student student)
    {
        Student savedStudent = studentDAO.saveStudent(student);
        if(savedStudent == null)
        {
            log.info("Неуспешное сохранение");
            return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
        }
        log.info("Успешное сохранение");
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<Student> getStudent(int id)
    {

        Student student = studentDAO.getStudent(id);
        if(student == null)
        {
            log.info("Информация не получена");
            return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
        }
        log.info("Информация получена");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Student> deleteStudent(int id)
    {

        Student student = studentDAO.getStudent(id);
        if(student == null)
        {
            log.info("Неудачное удаление");
            return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
        }
        studentDAO.deleteStudent(id);
        log.info("Успешное удаление");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
