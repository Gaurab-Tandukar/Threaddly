package com.Threaddly.Threaddly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Threaddly.Threaddly.entity.ReactionEntity;

@Repository
public interface ReactionRepository extends JpaRepository<ReactionEntity, String> {
    List<ReactionEntity> findByMessageId(String messageId);
    Optional<ReactionEntity> findByMessageIdAndUserIdAndEmoji(String messageId, String userId, String emoji);
    boolean existsByMessageIdAndUserIdAndEmoji(String messageId, String userId, String emoji);
}