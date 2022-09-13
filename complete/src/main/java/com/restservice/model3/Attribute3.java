package com.restservice.model3;

public class Attribute3 {

    public String object_id;
    public Boolean is_deleted;

    public Attribute3(String object_id, Boolean is_deleted) {
        this.object_id = object_id;
        this.is_deleted = is_deleted;
    }

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
