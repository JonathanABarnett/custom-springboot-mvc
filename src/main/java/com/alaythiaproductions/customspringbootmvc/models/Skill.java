package com.alaythiaproductions.customspringbootmvc.models;

public class Skill {

    private Long id;
    private String name;
    private String description;
    private Employee employee;

    public Skill() {}

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Skill(String name, String description, Employee employee) {
        this.name = name;
        this.description = description;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
