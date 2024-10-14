package com.geekathon.eventsDashboard.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String location;
    private LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "event_rsvp",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersRSVPd;

    public Event(String name, String description, String location, LocalDate date) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
    }
}
