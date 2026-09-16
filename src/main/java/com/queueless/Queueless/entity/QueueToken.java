package com.queueless.Queueless.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "queue_tokens",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_token_queue_number",
                        columnNames = {"queue_id", "token_number"}
                )
        },
        indexes = {
                @Index(
                        name = "idx_token_queue_status",
                        columnList = "queue_id, status"
                ),
                @Index(
                        name = "idx_token_queue_number",
                        columnList = "queue_id, token_number"
                ),
                @Index(
                        name = "idx_token_user",
                        columnList = "user_id"
                ),
                @Index(
                        name = "idx_token_appointment",
                        columnList = "appointment_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class QueueToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "queue_id", nullable = false)
    private Long queueId;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /*
     * Nullable because a walk-in customer
     * does not have an appointment.
     */
    @Column(name = "appointment_id")
    private Long appointmentId;

    @NotNull
    @Min(
            value = 1,
            message = "Token number must be greater than 0"
    )
    @Column(name = "token_number", nullable = false)
    private Integer tokenNumber;

    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String status = "WAITING";

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    @Column(name = "called_at")
    private LocalDateTime calledAt;

    @Column(name = "service_started_at")
    private LocalDateTime serviceStartedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();

        joinedAt = now;
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}