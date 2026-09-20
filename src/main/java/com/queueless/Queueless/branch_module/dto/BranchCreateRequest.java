package com.queueless.Queueless.branch_module.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchCreateRequest {

    @NotNull(message = "Organization ID is required")
    private Long organizationId;

    @NotBlank(message = "Branch name is required")
    @Size(max = 150, message = "Branch name must not exceed 150 characters")
    private String name;

    @NotBlank(message = "Address line 1 is required")
    @Size(max = 255, message = "Address line 1 must not exceed 255 characters")
    private String addressLine1;

    @Size(max = 255, message = "Address line 2 must not exceed 255 characters")
    private String addressLine2;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must not exceed 100 characters")
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State must not exceed 100 characters")
    private String state;

    @Size(max = 20, message = "Postal code must not exceed 20 characters")
    private String postalCode;

    @Builder.Default
    private String country = "India";

    @Builder.Default
    private String timezone = "Asia/Kolkata";
}