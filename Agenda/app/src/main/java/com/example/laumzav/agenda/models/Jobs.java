package com.example.laumzav.agenda.models;

import java.io.Serializable;

public class Jobs implements Serializable {
    private int id;
    private String name;
    private String desc;
    private float priority;

    public Jobs(int id, String jobName, String jobDesc, float priority){
        this.id = id;
        this.name = jobName;
        this.desc = jobDesc;
        this.priority = priority;
    }

    public Jobs(String jobName, String jobDesc, float priority){
        this.name = jobName;
        this.desc = jobDesc;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public float getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }
}
