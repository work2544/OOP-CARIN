package com.api.carinapi.Controllers;

import com.api.carinapi.beans.testClass;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class TestController {
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
}
