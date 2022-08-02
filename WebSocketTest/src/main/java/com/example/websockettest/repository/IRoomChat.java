package com.example.websockettest.repository;

import com.example.websockettest.model.RoomChat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomChat extends CrudRepository<RoomChat, Integer> {
    RoomChat getRoomChatBySenderAndReceiver(String sender, String receiver);
}
