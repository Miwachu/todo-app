package com.example.message.model;
 
import jakarta.persistence.*;
 
@Entity
public class Message {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;

    private String deadline;
 
    // ★ 新增：完成状态字段
    private boolean done;
 

    public Message() {
        // JPA 要求的无参构造器
    }

 
    public Message(String name, String deadline) {
        this.name = name;
        this.deadline = deadline;
        this.done = false;  // 默认未完成

    }
 
 
    // ——— Getter/Setter ———
 
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }

   public String getDeadline(){
        return deadline;
   
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }
 
    public void setDone(boolean done) {
        this.done = done;
    }
}