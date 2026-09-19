package com.queueless.Queueless.membership_module.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationMembershipCreateRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Organization ID is required")
    private Long organizationId;

    @NotBlank(message = "Role is required")
    @Size(
            max = 20,
            message = "Role must not exceed 20 characters"
    )
    private String role;
}