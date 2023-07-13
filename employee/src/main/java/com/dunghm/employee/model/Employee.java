package com.dunghm.employee.model;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String image;
    private String address;
    private String job;

    public Employee(Integer id, String name, Integer age, String image, String address, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.image = image;
        this.address = address;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
