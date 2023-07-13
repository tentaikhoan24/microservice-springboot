package com.dunghm.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "employees")
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(name = "age", columnDefinition = "INT")
    private Integer age;
    @Column(name = "image", columnDefinition = "VARCHAR(255)")
    private String image;
    @Column(name = "address", columnDefinition = "VARCHAR(255)")
    private String address;
    @Column(name = "job", columnDefinition = "VARCHAR(255)")
    private String job;

    public Employee() {
    }

    public Employee(Long id, String name, Integer age, String image, String address, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.image = image;
        this.address = address;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
