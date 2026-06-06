package com.Threaddly.Threaddly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Threaddly.Threaddly.entity.ConversationEntity;

@Repository
public interface ConversationRepository extends JpaRepository<ConversationEntity, String> {
}