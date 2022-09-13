package com.restservice.model1;

import java.util.List;

public class CreateSotrudnikRequest {

    public String Filial_ID;
    public List<Attribute1> attributes1;

    public String getFilial_ID() {
        return Filial_ID;
    }

    public void setFilial_ID(String filial_ID) {
        Filial_ID = filial_ID;
    }

    public List<Attribute1> getAttributes1() {
        return attributes1;
    }

    public void setAttributes1(List<Attribute1> attributes1) {
        this.attributes1 = attributes1;
    }
}
