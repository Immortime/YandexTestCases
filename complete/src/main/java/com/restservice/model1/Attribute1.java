package com.restservice.model1;

public class Attribute1 {

    public String name;
    public String value;

    public Attribute1(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Attribute1() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
