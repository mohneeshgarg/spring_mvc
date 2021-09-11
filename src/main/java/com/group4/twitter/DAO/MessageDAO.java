package com.group4.twitter.DAO;

import com.group4.twitter.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageDAO extends JpaRepository<Message, Integer> {

    @Query(value="SELECT * FROM twitter_message WHERE sender_id = :sender_id", nativeQuery = true)
    List<Message> findSentMessages(@Param("sender_id") int senderId);

    @Query(value="SELECT * FROM twitter_message WHERE receiver_id = :receiver_id", nativeQuery = true)
    List<Message> findReceivedMessages(@Param("receiver_id") int receiverId);

}