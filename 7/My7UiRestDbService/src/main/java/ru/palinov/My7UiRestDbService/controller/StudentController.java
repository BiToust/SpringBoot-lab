package ru.palinov.My7UIRestDbService.controller;

import ru.palinov.My7UIRestDbService.entity.Student;
import ru.palinov.My7UIRestDbService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Главная страница со списком студентов
    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list-students";
    }

    // Показать форму для добавления студента
    @GetMapping("/addStudentForm")
    public String showAddForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student-form";
    }

    // Сохранить нового студента
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/list";
    }

    // Показать форму для редактирования
    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("studentId") int id, Model model) {
        Student student = studentRepository.findById(id).get();
        model.addAttribute("student", student);
        return "add-student-form";
    }

    // Удалить студента
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int id) {
        studentRepository.deleteById(id);
        return "redirect:/list";
    }
}