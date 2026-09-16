package com.queueless.Queueless.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "queues",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_queue_service_date",
                        columnNames = {"service_id", "queue_date"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "service_id", nullable = false)
    private Long serviceId;

    @NotNull
    @Column(name = "queue_date", nullable = false)
    private LocalDate queueDate;

    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String status = "OPEN";

    @NotNull
    @Min(
            value = 1,
            message = "Next token number must be greater than 0"
    )
    @Column(name = "next_token_number", nullable = false)
    private Integer nextTokenNumber = 1;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}