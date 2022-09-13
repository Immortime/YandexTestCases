package com.example.demo12.controller;

import com.example.demo12.dtos.Attributes1;
import com.example.demo12.dtos.Doljnost;
import com.example.demo12.dtos.Root;
import com.example.demo12.service.Attributes1Service;
import com.example.demo12.service.DoljnostService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {


//    DoljnostService doljnostService;
//    Attributes1Service attributes1Service;
//
//
//    public RootController(DoljnostService doljnostService, Attributes1Service attributes1Service) {
//        this.doljnostService = doljnostService;
//        this.attributes1Service = attributes1Service;
//
//    }

    @PostMapping("/create")
    public Doljnost createSotrudnik(@RequestBody Doljnost doljnost) {
        return doljnostService.save(doljnost);
    }

    @PostMapping("/find/{id}")
    public Root findById(@RequestBody Root root, @PathVariable String id) {
        Attributes1 attributes1 = new Attributes1();
            root.filial_ID = id;
        attributes1Service.setAppointment(attributes1);
        attributes1Service.setFilial_id(attributes1);
        attributes1Service.setFilial_name(attributes1);
        attributes1Service.setIs_deleted(attributes1);
        attributes1Service.setObject_id(attributes1);
        root.attributes1.add(attributes1);
            return root;
    }
}
