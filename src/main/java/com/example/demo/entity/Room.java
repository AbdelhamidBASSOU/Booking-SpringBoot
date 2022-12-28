package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Room")
public class Room  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId", nullable = false)
    private Long id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "roomNumber")
    private int roomNumber;

    @Column(name = "type")
    private String type;


    @Column(name = "price")
    private double price;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Reservation reservation;

}