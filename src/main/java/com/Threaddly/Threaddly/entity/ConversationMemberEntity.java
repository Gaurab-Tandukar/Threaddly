package com.Threaddly.Threaddly.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "conversation_members")
public class ConversationMemberEntity {

    @Id
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private ConversationEntity conversation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.member;

    private LocalDateTime joinedAt;
    private LocalDateTime lastReadAt;

    public enum Role { admin, member }

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = java.util.UUID.randomUUID().toString();
        if (this.joinedAt == null) this.joinedAt = LocalDateTime.now();
    }
}