package com.qd.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:zhoujuhnhua
 * date:2020/1/21
 * desc:
 **/
@XmlRootElement
public class Student {
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String firstname, String lastname, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
