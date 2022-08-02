package com.example.websockettest.service;

import com.example.websockettest.model.RoomChat;
import com.example.websockettest.repository.IRoomChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomChatService {
    @Autowired
    IRoomChat iRoomChat;
    public int getIdRoom(String sen,String re){
        RoomChat roomChat  = iRoomChat.getRoomChatBySenderAndReceiver(sen,re);
        if (roomChat!=null){
            return roomChat.getId();
        }else {
            return iRoomChat.getRoomChatBySenderAndReceiver(re,sen).getId();
        }

    }
}
