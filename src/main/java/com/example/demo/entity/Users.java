package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   @Column(name = "first_name")
    private String firstName;

   @Column(name = "last_name")
    private String lastName;

   @Column(name = "username")
    private String username;

   @Column(name = "email")
    private String email;

   @Column(name = "password")
    private String password;

   @Column(name = "reference")
   private String reference;


   @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Reservation> reservationList;


    private boolean isBanned;
}
