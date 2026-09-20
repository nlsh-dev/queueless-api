package com.queueless.Queueless.branch_module.entity;

import com.queueless.Queueless.organization_module.entity.Organization;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "branches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @NotBlank(message = "Branch name is required")
    @Size(max = 150, message = "Branch name must not exceed 150 characters")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotBlank(message = "Address line 1 is required")
    @Size(max = 255, message = "Address line 1 must not exceed 255 characters")
    @Column(name = "address_line1", nullable = false, length = 255)
    private String addressLine1;

    @Size(max = 255, message = "Address line 2 must not exceed 255 characters")
    @Column(name = "address_line2", length = 255)
    private String addressLine2;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must not exceed 100 characters")
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State must not exceed 100 characters")
    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @Size(max = 20, message = "Postal code must not exceed 20 characters")
    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(name = "country", nullable = false, length = 100)
    @Builder.Default
    private String country = "India";

    @Column(name = "timezone", nullable = false, length = 50)
    @Builder.Default
    private String timezone = "Asia/Kolkata";

    @Column(name = "status", nullable = false, length = 20)
    @Builder.Default
    private String status = "ACTIVE";

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
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

        if (country == null) {
            country = "India";
        }

        if (timezone == null) {
            timezone = "Asia/Kolkata";
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