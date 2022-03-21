package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentByName(String name);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    void addStudent(Student student);
    void updateStudent(Long id, Student newStudent);
}
