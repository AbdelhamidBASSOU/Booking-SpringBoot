package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Users{
    @Column(name = "reference")
    private String reference;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Reservation> reservationList;


}
