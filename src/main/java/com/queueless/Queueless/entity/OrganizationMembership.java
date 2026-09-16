package com.queueless.Queueless.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "organization_memberships",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_membership_organization_user",
                        columnNames = {"organization_id", "user_id"}
                )
        },
        indexes = {
                @Index(
                        name = "idx_membership_user",
                        columnList = "user_id"
                ),
                @Index(
                        name = "idx_membership_org_role",
                        columnList = "organization_id, role"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class OrganizationMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "organization_id", nullable = false)
    private Long organizationId;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotBlank
    @Size(max = 20)
    @Pattern(
            regexp = "ADMIN|STAFF",
            message = "Role must be ADMIN or STAFF"
    )
    @Column(nullable = false, length = 20)
    private String role;

    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String status = "ACTIVE";

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

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