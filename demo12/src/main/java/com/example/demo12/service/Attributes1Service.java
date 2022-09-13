package com.example.demo12.service;

import com.example.demo12.dtos.Attributes1;
import com.example.demo12.dtos.Root;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Attributes1Service {

    DoljnostService doljnostService;
    Attributes1 attributes1;
    Root root;
    String id = doljnostService.findById(root.filial_ID).getObject_id();

    public Attributes1Service(DoljnostService doljnostService, Attributes1 attributes1, Root root) {
        this.doljnostService = doljnostService;
        this.attributes1 = attributes1;
        this.root = root;
    }

    public void setObject_id(Attributes1 attributes1) {
         attributes1.setKey(doljnostService.findById(root.filial_ID).getObject_id());
    }

    public void setFilial_id(Attributes1 attributes1) {
        attributes1.setKey(doljnostService.findById(root.filial_ID).getFilial_id());
    }

    public void setFilial_name(Attributes1 attributes1) {
        attributes1.setKey(doljnostService.findById(root.filial_ID).getFilial_name());
    }

    public void setAppointment(Attributes1 attributes1) {
        attributes1.setKey(doljnostService.findById(root.filial_ID).getAppointment());
    }

    public void setIs_deleted(Attributes1 attributes1) {
        attributes1.setKey(doljnostService.findById(root.filial_ID).getIs_deleted());
    }
}
