package com.Threaddly.Threaddly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Threaddly.Threaddly.entity.AttachmentEntity;

@Repository
public interface AttachmentRepository extends JpaRepository<AttachmentEntity, String> {
    List<AttachmentEntity> findByMessageId(String messageId);
}