package com.gradle.demo.base.extend;

import java.time.LocalDate;

/**
 * @author guxc
 * @date 2020/6/11
 */
public class Manager extends Employee {

    static {
        System.out.println("manager static block");
    }

    {
        System.out.println("manager block");
    }

    public Manager() {
        System.out.println("manager constructor");
    }

    public Manager(String name, double salary, LocalDate hireDate, double bonus) {

        super(name, salary, hireDate);
        this.bonus = bonus;
        System.out.println("manager  all args constructor");
    }

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary(){
        return super.getSalary() + bonus;
    }
}
