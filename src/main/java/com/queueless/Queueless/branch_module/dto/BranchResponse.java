package com.queueless.Queueless.branch_module.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchResponse {

    private Long id;

    private Long organizationId;

    private String name;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private String timezone;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}