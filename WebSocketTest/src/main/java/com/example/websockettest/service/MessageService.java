package com.example.websockettest.service;

import com.example.websockettest.model.MessageChat;
import com.example.websockettest.repository.IMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    IMessageRepo iMessageRepo;

    public List<MessageChat> getAll(String sender, String receiver){
       List<MessageChat> messageChats = iMessageRepo.findAllBySenderAndReceiver(receiver,sender);
        messageChats.addAll(iMessageRepo.findAllBySenderAndReceiver(sender,receiver));
        return messageChats;
    }
    public void save(MessageChat messageChat){
        iMessageRepo.save(messageChat);
    }
    public Iterable<MessageChat> findAllBySender(String sender) {
        return iMessageRepo.findAllBySender(sender);
    }
}
