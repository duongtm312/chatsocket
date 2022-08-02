package com.example.websockettest.controller;

import com.example.websockettest.model.MessageChat;
import com.example.websockettest.service.MessageService;
import com.example.websockettest.service.RoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class RestMessage {
    @Autowired
    MessageService messageService;
    @Autowired
    RoomChatService roomChatService;
    @GetMapping
    public List<MessageChat> index(@RequestParam String sender, @RequestParam String receiver) {
        return messageService.getAll(sender,receiver);
    }
    @GetMapping("/room")
    public int roon(@RequestParam String sender, @RequestParam String receiver){
        return roomChatService.getIdRoom(sender,receiver);
    }
    @GetMapping("/response")
    public ResponseEntity<Iterable<MessageChat>> getI(@RequestParam String sender) {
        return new ResponseEntity<>(messageService.findAllBySender(sender), HttpStatus.OK);
    }
}
