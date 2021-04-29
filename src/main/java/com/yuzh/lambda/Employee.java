package com.yuzh.lambda;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private Integer age;
    private Double account;
    private Status status;

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }

    public Employee(int id, String name, Integer age, Double account, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.account = account;
        this.status = status;
    }

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public Employee(int id, String name, int age, double account) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                name.equals(employee.name) &&
                age.equals(employee.age) &&
                account.equals(employee.account) &&
                status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, account);
    }

    public Integer getAge() {
        return age;
    }

    public Double getAccount() {
        return account;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                ", status=" + status +
                '}';
    }
}
