package com.example.message.model;
 
import jakarta.persistence.*;
 
@Entity
public class Message {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
    private String text;
 
    // ★ 新增：完成状态字段
    private boolean done;
 
    public Message() {
        // JPA 要求的无参构造器
    }
 
    public Message(String name, String text) {
        this.name = name;
        this.text = text;
        this.done = false;  // 默认未完成
    }
 
 
    // ——— Getter/Setter ———
 
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public String getText() {
        return text;
    }
 
    // ★ 新增 done 的 getter/setter
 
    public boolean isDone() {
        return done;
    }
 
    public void setDone(boolean done) {
        this.done = done;
    }
}