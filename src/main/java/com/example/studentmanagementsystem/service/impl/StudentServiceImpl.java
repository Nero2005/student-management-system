package com.example.studentmanagementsystem.service.impl;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repo.StudentRepo;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepo.getStudentByName(name);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = getStudentById(studentId);
        studentRepo.delete(student);
    }

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudent(Long id, Student newStudent) {
        Student student = getStudentById(id);
        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        studentRepo.save(student);
    }
}
