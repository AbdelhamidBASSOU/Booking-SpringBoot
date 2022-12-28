package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager extends Users {

    @Column(name = "reference")
    private String reference;

    @OneToOne
    private Hotel hotel;
}
