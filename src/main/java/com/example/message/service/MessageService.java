package com.example.message.service;

import com.example.message.model.Message;
import com.example.message.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository){
        this.repository = repository;
    }

    public List<Message> getAllMessages(){
        return repository.findAll();
    }

    public void addMessage(String name, String deadline){
        repository.save(new Message(name,deadline.toString()));
    }

    // ① 完了処理：update_todo に対応
    public void updateMessage(Long id) {
        repository.findById(id).ifPresent(message -> {
            // 假设你给 Message 加了 done 字段
            message.setDone(true);
            repository.save(message);
        });
    }
 
    // ② 削除処理：delete_todo に対応
    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }

    public Message getMessageById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void updateMessageContent(Long id, String name, String deadline) {
        repository.findById(id).ifPresent(message -> {
            message.setName(name);
            message.setDeadline(deadline);
            repository.save(message);
        });
    }

}