package com.example.laumzav.agenda.models;

public class Jobs {
    private int id;
    private String name;
    private String desc;
    private float priority;

    public Jobs(){

    }

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

    public int getId() {
        return id;
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
