package com.geekathon.eventsDashboard.Config;

import com.geekathon.eventsDashboard.Entities.Event;
import com.geekathon.eventsDashboard.Entities.User;
import com.geekathon.eventsDashboard.Repositories.EventRepository;
import com.geekathon.eventsDashboard.Repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ConfigCommand {

    @Bean
    org.springframework.boot.CommandLineRunner commandLineRunner(UserRepository userRepository,
                                                                 EventRepository eventRepository) {

        return args -> {
            User user = new User("TestUser", "Test@gmail.com", "testPass");
            User user2 = new User("TestUser2", "Test2@gmail.com", "testPass2");
            Event event = new Event("MedicalCamp", "TestDescription", "KRMU", LocalDate.now());
            Event event2 = new Event("MedicalCamp", "TestDescription", "KRMU", LocalDate.now());
            userRepository.saveAll(List.of(user, user2));
            eventRepository.saveAll(List.of(event, event2));
        };
    }

}
