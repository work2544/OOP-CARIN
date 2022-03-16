package com.api.carinapi.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.api.carinapi.beans.Create_virus;
import com.api.carinapi.beans.RecieveApi;
import com.api.carinapi.beans.SenderApi;
import com.api.carinapi.beans.SenderApi_Info;

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
    List<SenderApi> returnList = new ArrayList<>();
    
    @PostMapping("/create")
    public String add(@RequestBody RecieveApi antibody){
        RecieveApi newAntibody = new RecieveApi(antibody.getData(), antibody.isPause());

        //SenderApi_Info info = new SenderApi_Info("melee", 0, 0);
        //SenderApi returnVirus = new SenderApi()
        //returnList.add(new SenderApi(antibody.getData(), true));
        return "added";
    }

    @GetMapping("/getAll")
    public List<SenderApi> list(){
        return returnList;
    }
}
