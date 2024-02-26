package org.example.controller;

import org.example.dto.StudentDto;
import org.example.entity.Student;
import org.example.repository.StudentNativeRepositiry;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentNativeRepositiry studentNativeRepositiry;
    @GetMapping("get-student-list")
     List<StudentDto> getAllStudent() throws InterruptedException {
        //Thread.sleep(5000);
        return studentService.getAllStudent();
    }
    @PostMapping("save-student")
     StudentDto saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Map deleteStudent(@PathVariable  int id){
        boolean b = studentNativeRepositiry.removeStudent(id);
        if(b){
           return Collections.singletonMap("status", String.format("Deleted Student(%s) Successfuly",id));
        }
        return Collections.singletonMap("Ststud",String.format("Not Deleted Student(%s) Successfuly",id));
    }
}
