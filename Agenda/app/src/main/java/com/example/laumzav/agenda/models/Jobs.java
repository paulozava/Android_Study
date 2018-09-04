package com.example.laumzav.agenda.models;

public class Jobs {
    private long id;
    private String name;
    private String desc;
    private String deletable;
    private float priority;

    public Jobs(long id, String jobName, String jobDesc, String deletable, float priority){
        this.name = jobName;
        this.desc = jobDesc;
        this.deletable = deletable;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isDeletable() {
        if (deletable == "true"){
            return true;
        }
        return false;
    }

    public String getDeletable() {
        return deletable;
    }

    public float getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
