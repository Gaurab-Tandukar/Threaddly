package com.Threaddly.Threaddly.entity;

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
@Table(name = "attachments")
public class AttachmentEntity {

    @Id
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private MessageEntity message;

    @Column(nullable = false, length = 500)
    private String fileUrl;

    @Column(nullable = false)
    private String fileType;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private int fileSize;

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = java.util.UUID.randomUUID().toString();
    }
}