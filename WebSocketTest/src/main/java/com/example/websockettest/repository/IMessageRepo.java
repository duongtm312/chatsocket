package com.example.websockettest.repository;

import com.example.websockettest.model.MessageChat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepo extends CrudRepository<MessageChat, Integer> {

    List<MessageChat> findAllBySenderAndReceiver(String sender,String receiver);
    Iterable<MessageChat>findAllBySender(String sender);

}
