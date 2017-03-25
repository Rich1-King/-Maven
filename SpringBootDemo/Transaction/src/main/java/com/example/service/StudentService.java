package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rich1 on 9/20/16.
 */
@Service
public class StudentService{

    @Autowired
    StudentRepository studentRepository;

    public String add(Student student){
        try{
            studentRepository.save(student);
            return "成功";
        }catch (Exception e){
            return "失败" + e;
        }
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

}
