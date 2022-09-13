package com.example.demo12.dtos;

import com.example.demo12.service.DoljnostService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Attributes1 {
    public String key;
    public String value;

    public Attributes1(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Attributes1() {
    }

    Root root;
    DoljnostService doljnostService;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attributes1{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
