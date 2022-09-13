package com.example.demo12.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doljnost {
    private String FIO;
    @Id
    private String object_id;
    private String Filial_name;
    private String Filial_id;
    private String is_deleted;
    private String appointment;

    public Doljnost() {
    }


    public Doljnost(String FIO, String object_id, String filial_name, String filial_id, String is_deleted, String appointment) {
        this.FIO = FIO;
        this.object_id = object_id;
        Filial_name = filial_name;
        Filial_id = filial_id;
        this.is_deleted = is_deleted;
        this.appointment = appointment;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getAppointment() {
        return appointment;
    }
    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public String getFilial_name() {
        return Filial_name;
    }

    public void setFilial_name(String filial_name) {
        Filial_name = filial_name;
    }

    public String getFilial_id() {
        return Filial_id;
    }

    public void setFilial_id(String filial_id) {
        Filial_id = filial_id;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Doljnost{" +
                "FIO='" + FIO + '\'' +
                ", object_id='" + object_id + '\'' +
                ", Filial_name='" + Filial_name + '\'' +
                ", Filial_id='" + Filial_id + '\'' +
                ", is_deleted=" + is_deleted +
                '}';
    }
}

