package com.example.demo12.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Root{
    public String returnCode;
    public String returnMessage;
    @JsonProperty("Filial_ID")
    public String filial_ID;
    public ArrayList<Attributes1> attributes1;
}