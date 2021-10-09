package com.example.demo.model;


import io.swagger.annotations.Api;
import lombok.Data;

import javax.persistence.*;


@Api(value="Designer model", description = "Designer model")
@Table(name = "designer")
@Data
@Entity
public class Designer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
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


}
