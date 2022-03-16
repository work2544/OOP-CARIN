package com.api.carinapi.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.api.carinapi.beans.Student;
import com.api.carinapi.beans.testClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/student")

public class TestController {
    List<Student> studentList = new ArrayList<>();

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentList.add(new Student(student.getId(), student.getName(), student.getAddress()));
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentList;
    }

    @GetMapping("/test")
    public String getTest(){
        return "Test map";
    }

    @GetMapping("/arraTest")
    public int[] getArraTest(){
        int[] arr = {1, 2, 3};
        return arr;
    }

    @GetMapping("/classTest")
    public testClass getClassTest(){
        testClass test = new testClass("Test", 0);
        return test;
    }

    @GetMapping("/getGrade/{name}/{score}")
    public String getGrade(@PathVariable String name, @PathVariable double score){
        if(score >= 80){
            return name + "got A";
        }else {
            return name + "got F";
        }
    }

    @GetMapping("/generated/{name}/{count}")
    public List<String> getGenerated(@PathVariable String name, @PathVariable int count){
        List<String> returnText = new ArrayList<>();
        for(int i=0; i<count; i++){
            String Text = name + "count";
            returnText.add(Text);
        }
        return returnText;
    }

    
}
