package org.example.service;

import org.example.dto.StudentDto;
import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public StudentDto saveStudent(Student student) {
        studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }
    public List<StudentDto> getAllStudent(){
        Iterable<Student> all = studentRepository.findAll();
        Iterator<Student> iterator = all.iterator();
        List<StudentDto> list=new ArrayList<>();
        while(iterator.hasNext()){
            Student next = iterator.next();
            StudentDto map = modelMapper.map(next, StudentDto.class);
            list.add(map);
        }
        return list;
    }
    public boolean removeStudent(int id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Student student1 = student.get();//not required to this scenariyo
            studentRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
