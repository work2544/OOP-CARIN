package com.api.carinapi.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.carinapi.beans.RecieveApi;
import com.api.carinapi.beans.SenderApi;

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
    public Map<String, String> add(@RequestBody RecieveApi antibody){
        RecieveApi newAntibody = new RecieveApi(antibody.getData(), antibody.isPause());

        //SenderApi_Info info = new SenderApi_Info("melee", 0, 0);
        //SenderApi returnVirus = new SenderApi()
        //returnList.add(new SenderApi(antibody.getData(), true));
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "melee");
        map.put("posx", "0");
        map.put("posy", "0");
        return map;
    }

    @GetMapping("/getAll")
    public List<SenderApi> list(){
        return returnList;
    }
}
