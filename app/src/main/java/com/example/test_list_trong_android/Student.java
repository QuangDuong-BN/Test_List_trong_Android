package com.example.test_list_trong_android;

public class Student {
    private String id;
    private String name;
    private String sex;
    private String dateOfBirth;
    private String dirthplace;

    public Student(){};

    public Student(String id, String name, String sex, String dateOfBirth, String dirthplace) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dirthplace = dirthplace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDirthplace() {
        return dirthplace;
    }

    public void setDirthplace(String dirthplace) {
        this.dirthplace = dirthplace;
    }
}
