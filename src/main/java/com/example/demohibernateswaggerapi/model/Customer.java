package com.example.demohibernateswaggerapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/*
 * Entity: stabiliscee che l'entità va persistita come una tabella
 * */

@Entity
@Data
public class Customer {

    /*
     * SequenceGenerator: crea autonomanente la sequence che verrà poi associata alla proprietà id (PK)
     * */
    @Id
    @SequenceGenerator(name = "sqn_customer", sequenceName = "SQN_CUSTOMER", initialValue = 1, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqn_customer")
    private Long id;


    @NotBlank
    @Size(min = 0, max = 30)
    private String firstName;

    @NotBlank
    @Size(min = 0, max = 30)
    private String lastName;


}


