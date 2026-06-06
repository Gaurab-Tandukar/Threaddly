package com.Threaddly.Threaddly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Threaddly.Threaddly.entity.ConversationMemberEntity;

@Repository
public interface ConversationMemberRepository extends JpaRepository<ConversationMemberEntity, String> {
    List<ConversationMemberEntity> findByUserId(String userId);
    List<ConversationMemberEntity> findByConversationId(String conversationId);
    Optional<ConversationMemberEntity> findByConversationIdAndUserId(String conversationId, String userId);
    boolean existsByConversationIdAndUserId(String conversationId, String userId);
}