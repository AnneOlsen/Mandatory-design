package com.example.demo.model;


import io.swagger.annotations.Api;
import lombok.Data;

import javax.persistence.*;


@Api(value="Designer model", description = "Designer model")
@Table(name = "designer")

@Entity
public class Designer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id;
    @Column
    private String firstName;
    @Column
    private String sirName;
    @Column
    private int birthYear;
    @Column
    private String nationality;
    @Enumerated(value = EnumType.STRING)
    @Column
    Gender gender;

    public Designer(int id, String firstName, String sirName, int birthYear, String nationality, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.sirName = sirName;
        this.birthYear = birthYear;
        this.nationality = nationality;
        this.gender = gender;
    }

    public Designer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
