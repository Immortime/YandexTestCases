package com.restservice.model2;

public class Attribute2 {

    public String key;
    public String value;

    public Attribute2(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Attribute2() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setName(String key) {
        this.key = key;
    }
}
