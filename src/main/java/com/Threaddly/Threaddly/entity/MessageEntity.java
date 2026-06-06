package com.Threaddly.Threaddly.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private ConversationEntity conversation;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private UserEntity sender;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type = Type.text;

    @ManyToOne
    @JoinColumn(name = "reply_to_id")
    private MessageEntity replyTo;

    @Column(nullable = false)
    private boolean isEdited = false;

    @Column(nullable = false)
    private boolean isDeleted = false;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<AttachmentEntity> attachments;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<ReactionEntity> reactions;

    public enum Type { text, image, file, system }

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = java.util.UUID.randomUUID().toString();
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
        if (this.updatedAt == null) this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}