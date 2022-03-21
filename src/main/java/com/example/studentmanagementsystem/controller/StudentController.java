package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/add")
    public String addStudentsPage(Model model) {
        model.addAttribute("editable", false);
        return "student";
    }

    @GetMapping("/students/update")
    public String updateStudentsPage(@RequestParam(value = "id") Integer id, Model model) {
        Long l = Long.valueOf(id);
        Student student = studentService.getStudentById(l);
        model.addAttribute("student", student);
        model.addAttribute("editable", true);
        return "student";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam(value = "name") String name,
                             @RequestParam(value = "email") String email,
                             Model model) {
        studentService.addStudent(new Student(name, email));
        return "redirect:/students";
    }

    @GetMapping("/")
    public String gotoStudents(HttpServletRequest request) {
        return "redirect:/students";
    }

    @PostMapping("/students/update")
    public String updateStudent(@RequestParam(value = "id") Integer id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "email") String email,
                             Model model) {
        Long l = Long.valueOf(id);
        studentService.updateStudent(l, new Student(name, email));
        return "redirect:/students";
    }

    @PostMapping("/students/delete")
    public String deleteStudent(@RequestParam(value = "id") Integer id, Model model) {
        Long l = Long.valueOf(id);
        studentService.deleteStudent(l);
        return "redirect:/students";
    }
}
