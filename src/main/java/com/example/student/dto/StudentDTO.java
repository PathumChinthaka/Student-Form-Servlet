package com.example.student.dto;

public class StudentDTO {
    private int studentID;
    private String name;
    private String city;
    private String email;
    private int level;

    public StudentDTO(int studentID, String name, String city, String email, int level) {
        this.studentID = studentID;
        this.name = name;
        this.city = city;
        this.email = email;
        this.level = level;
    }

    public StudentDTO() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                '}';
    }
}
