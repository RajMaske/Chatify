package com.chatapp.service;

import com.chatapp.entity.Message;
import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    List<Message> getAllMessages();
}
