package com.example.message.model;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String deadline;

    public Message() {
    }

    public Message(String name, String deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDeadline(){
        return deadline;
    }

}