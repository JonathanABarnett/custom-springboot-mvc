package com.alaythiaproductions.customspringbootmvc.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String manager;
    @Min(0)
    private int numOfCurrentEmployees;
    @Max(99)
    private int maxNumOfEmployees;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department() {}

    public Department(String name, String manager, int numOfCurrentEmployees, int maxNumOfEmployees) {
        this.name = name;
        this.manager = manager;
        this.numOfCurrentEmployees = numOfCurrentEmployees;
        this.maxNumOfEmployees = maxNumOfEmployees;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getNumOfCurrentEmployees() {
        return numOfCurrentEmployees;
    }

    public void setNumOfCurrentEmployees(int numOfCurrentEmployees) {
        this.numOfCurrentEmployees = numOfCurrentEmployees;
    }

    public int getMaxNumOfEmployees() {
        return maxNumOfEmployees;
    }

    public void setMaxNumOfEmployees(int maxNumOfEmployees) {
        this.maxNumOfEmployees = maxNumOfEmployees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
