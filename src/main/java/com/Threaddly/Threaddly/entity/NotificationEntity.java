package com.Threaddly.Threaddly.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private MessageEntity message;

    @Column(nullable = false)
    private boolean isRead = false;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = java.util.UUID.randomUUID().toString();
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
    }
}