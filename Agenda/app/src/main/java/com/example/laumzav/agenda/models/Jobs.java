package com.example.laumzav.agenda.models;

public class Jobs {
    private long id;
    private String name;
    private String desc;
    private String isDeletable;
    private float priority;

    public Jobs(String jobName, String jobDesc, String isDeletable, float priority){
        this.name = jobName;
        this.desc = jobDesc;
        this.isDeletable = isDeletable;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String isDeletable() {
        return isDeletable;
    }

    public float getPriority() {
        return priority;
    }
}
