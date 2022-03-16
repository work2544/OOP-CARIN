package com.api.carinapi.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.api.carinapi.beans.Create_antibody;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//java getjson parse
@RestController
@CrossOrigin
@RequestMapping("/Antibody")
public class UnitController {
    List<Create_antibody> antibodyList = new ArrayList<>();
    
    @PostMapping("/create")
    public String add(@RequestBody Create_antibody antibody){
        antibodyList.add(new Create_antibody(antibody.getType(), antibody.getPosx(), antibody.getPosy()));
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Create_antibody> list(){
        return antibodyList;
    }
}
