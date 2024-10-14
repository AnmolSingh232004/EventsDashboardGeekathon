package com.geekathon.eventsDashboard.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data // From Lombok for getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "usersRSVPd")
    private List<Event> eventsRSVPd;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

