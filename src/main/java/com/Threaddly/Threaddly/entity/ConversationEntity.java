package com.Threaddly.Threaddly.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "conversations")
public class ConversationEntity {

    @Id
    @Column(length = 36)
    private String id;

    private String name;

    @Column(nullable = false)
    private boolean isGroup = false;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL)
    private List<ConversationMemberEntity> members;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL)
    private List<MessageEntity> messages;

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = java.util.UUID.randomUUID().toString();
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
    }
}