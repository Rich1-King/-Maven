package com.example.control;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rich1 on 9/20/16.
 */
@RestController
public class StudentCtrl{

    @Autowired
    StudentService studentService;

    @RequestMapping("/save")
    public String save(String sid, String name){

        Student student = new Student();
        student.setSid(sid);
        student.setName(name);
        return studentService.add(student);
    }

    @RequestMapping("/getStudent")
    public List<Student> getAll(){
        return studentService.getStudents();
    }
}
