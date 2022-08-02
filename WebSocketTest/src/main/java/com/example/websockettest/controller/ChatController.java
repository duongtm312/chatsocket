package com.example.websockettest.controller;

import com.example.websockettest.model.MessageChat;
import com.example.websockettest.model.RoomChat;
import com.example.websockettest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin("*")
public class ChatController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @GetMapping("/chat")
    public ModelAndView chat() {

        return new ModelAndView("index");
    }

    @Autowired
    MessageService messageService;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload MessageChat messageChat) {
        messageService.save(messageChat);
        simpMessagingTemplate.convertAndSend("/chatroom/public/"+ messageChat.getIdRoom(), messageChat);

    }


}
