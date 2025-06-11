package com.example.message.controller;

import com.example.message.service.MessageService;
import com.example.message.model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService service){
        this.service =service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String deadline,
                       Model model) {
        if(name.isBlank() || deadline.isBlank()){
            model.addAttribute("error", "名前とメッセージは必須です");

        }else{
            service.addMessage((name), deadline);
        }
        
        List<Message> messages = service.getAllMessages();
        model.addAttribute("messages", messages);
        return "index";
    }

    @PostMapping("/update_todo")
    public String updateTodo(@RequestParam("todo_id") Long id) {
        service.updateMessage(id);        // 你的 Service 里应该有对应的 update 方法
        return "redirect:/";                  // 相当于 redirect(url_for('show_todos'))
    }
 
    /** 削除処理（delete_todo に対応） */
    @PostMapping("/delete_todo")
    public String deleteTodo(@RequestParam("todo_id") Long id) {
        service.deleteMessage(id);        // 你的 Service 里应该有对应的 delete 方法
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable Long id, Model model) {
        Message message = service.getMessageById(id);
        model.addAttribute("editMessage", message);
        model.addAttribute("messages", service.getAllMessages());
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @RequestParam String name, @RequestParam String deadline) {
        service.updateMessageContent(id, name, deadline);
        return "redirect:/";
    }
}