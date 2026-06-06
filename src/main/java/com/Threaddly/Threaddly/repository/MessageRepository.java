package com.Threaddly.Threaddly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Threaddly.Threaddly.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, String> {
    List<MessageEntity> findByConversationIdOrderByCreatedAtAsc(String conversationId);
    List<MessageEntity> findBySenderId(String senderId);
}