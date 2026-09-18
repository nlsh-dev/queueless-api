package com.queueless.Queueless.User_Module.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_users_email",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "uk_users_phone",
                        columnNames = "phone"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Column(
            name = "name",
            nullable = false,
            length = 100
    )
    private String name;







    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    @Column(
            name = "email",
            nullable = false,
            length = 255
    )
    private String email;






    @Size(max = 20, message = "Phone must not exceed 20 characters")
    @Column(
            name = "phone",
            length = 20
    )
    private String phone;




    @NotBlank(message = "Password hash is required")
    @Size(max = 255, message = "Password hash must not exceed 255 characters")
    @Column(
            name = "password_hash",
            nullable = false,
            length = 255
    )
    private String passwordHash;




    @Column(
            name = "status",
            nullable = false,
            length = 20
    )
    @Builder.Default
    private String status = "ACTIVE";





    @Column(
            name = "email_verified",
            nullable = false
    )
    @Builder.Default
    private Boolean emailVerified = false;

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

        if (emailVerified == null) {
            emailVerified = false;
        }
    }


    @PreUpdate
    protected void onUpdate() {

        updatedAt = LocalDateTime.now();
    }
}