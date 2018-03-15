package com.alaythiaproductions.customspringbootmvc.models;

import java.util.List;

public class Department {

    private long id;
    private String name;
    private String manager;
    private int numOfCurrentEmployees;
    private int maxNumOfEmployees;
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
