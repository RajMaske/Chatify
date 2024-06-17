package com.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chatapp.entity.Message;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ChatController {
    
    private Set<String> onlineUsers = new HashSet<>();
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/index")
    public String index1() {
        return "index";
    }

    @PostMapping("/chatPage")
    public String chatPage(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        onlineUsers.add(username);
        model.addAttribute("onlineUsers", onlineUsers);
        return "chatpage";
    }

    @GetMapping("/chatPage")
    public String chat(@RequestParam(name = "username", required = false) String username, Model model) {
        if (username == null || username.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("username", username);
        onlineUsers.add(username);
        model.addAttribute("onlineUsers", onlineUsers);
        return "chatpage";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}
