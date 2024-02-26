package org.example.service;

import org.example.dto.StudentDto;
import org.example.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto saveStudent(Student student);
     List<StudentDto> getAllStudent();
     boolean removeStudent(int id);
}
