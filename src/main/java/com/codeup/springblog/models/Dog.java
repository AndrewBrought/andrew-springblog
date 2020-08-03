package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INT(11) UNSIGNED", nullable = false)
    private int id;
    @Column(columnDefinition = "TINYINT(3) UNSIGNED", nullable = false)
    private int age;
    @Column(length = 200, nullable = false)
    String name;
    @Column(columnDefinition = "char(2)")
    String reside_state = "XX";

//    public Dog() {}

//    public Dog(int id, int age, String name, String reside_state) {
//        this.id = id;
//        this.age = age;
//        this.name = name;
//        this.reside_state = reside_state;
//    }
//
//    public int getId() {
//
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getReside_state() {
//        return reside_state;
//    }
//
//    public void setReside_state(String reside_state) {
//        this.reside_state = reside_state;
//    }
}


