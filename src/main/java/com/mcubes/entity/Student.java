package com.mcubes.entity;

import javax.persistence.*;

/**
 * Created by A.A.MAMUN on 10/25/2019.
 */
/*
 We can define table name by
 '@Entity(name = "student_info_table")'
 */
@Entity
public class Student {

    /*
    Add your class property.
    Hence 'Student' is an entity class that means you will get a table in your database,
    with the name of 'student' with column like this class property.
     */
    @Id
    @SequenceGenerator(name = "StudentSequence", sequenceName ="StudentSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StudentSequence")
    private Integer id;
    private String roll;
    /*
    We can define the length of column.
    Default length = 255
     */
    @Column(length = 500)
    private String name;
    /*
    We can define column by
    '@Column(name = "student_address")'
     */
    private String address;
    private String department;

    /*
    Default constructor
     */
    public Student(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", roll='" + roll + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
