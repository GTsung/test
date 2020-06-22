package com.gradle.demo.base.extend;

import java.time.LocalDate;

/**
 * @author guxc
 * @date 2020/6/11
 */
public class Employee {

    static {
        System.out.println("static block");
    }

    {
        System.out.println("block");
    }

    private String name;

    private double salary;

    private LocalDate hireDate;

    public Employee() {
        System.out.println("constructor");
    }

    public Employee(String name, double salary, LocalDate hireDate) {

        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
        System.out.println("all args constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }


}
