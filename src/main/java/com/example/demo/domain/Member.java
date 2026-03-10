package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public Member(String name, String email){
        this.name =name;
        this.email=email;
        this.createdAt= LocalDateTime.now();
    }

    public void update(String name, String email){
        if (name != null) this.name = name;
        if (email != null) this.email = email;
    }
}
