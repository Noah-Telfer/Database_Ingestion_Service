package com.mainframe.modernization.database_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "mainframe_sync_records") // Maps to your SQL Server table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainframeDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "raw_payload", columnDefinition = "NVARCHAR(MAX)")
    private String rawPayload;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    // A helper constructor for your Kafka listener
    public MainframeDataEntity(String rawPayload) {
        this.rawPayload = rawPayload;
        this.processedAt = LocalDateTime.now();
    }
}