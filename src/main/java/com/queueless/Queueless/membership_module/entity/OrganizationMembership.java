package com.queueless.Queueless.membership_module.entity;

import com.queueless.Queueless.User_Module.entity.User;
import com.queueless.Queueless.organization_module.entity.Organization;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "organization_memberships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "organization_id",
            nullable = false
    )
    private Organization organization;

    @NotBlank(message = "Role is required")
    @Size(
            max = 20,
            message = "Role must not exceed 20 characters"
    )
    @Column(
            name = "role",
            nullable = false,
            length = 20
    )
    private String role;

    @Column(
            name = "status",
            nullable = false,
            length = 20
    )
    @Builder.Default
    private String status = "ACTIVE";

    @Column(
            name = "created_at",
            nullable = false
    )
    private LocalDateTime createdAt;

    @Column(
            name = "updated_at",
            nullable = false
    )
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {

        LocalDateTime now = LocalDateTime.now();

        if (createdAt == null) {
            createdAt = now;
        }

        if (updatedAt == null) {
            updatedAt = now;
        }

        if (status == null) {
            status = "ACTIVE";
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}