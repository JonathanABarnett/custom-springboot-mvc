package com.alaythiaproductions.customspringbootmvc.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
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

    public int getId() {
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
