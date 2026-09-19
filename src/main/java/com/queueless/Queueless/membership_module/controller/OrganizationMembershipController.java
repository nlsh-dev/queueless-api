package com.queueless.Queueless.membership_module.controller;

import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.membership_module.dto.OrganizationMembershipCreateRequest;
import com.queueless.Queueless.membership_module.dto.OrganizationMembershipResponse;
import com.queueless.Queueless.membership_module.service.OrganizationMembershipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memberships")
@RequiredArgsConstructor
public class OrganizationMembershipController {

    private final OrganizationMembershipService membershipService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrganizationMembershipResponse>> createMembership(
            @Valid @RequestBody OrganizationMembershipCreateRequest request) {

        ApiResponse<OrganizationMembershipResponse> response =
                membershipService.createMembership(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrganizationMembershipResponse>> getMembershipById(
            @PathVariable Long id) {

        ApiResponse<OrganizationMembershipResponse> response =
                membershipService.getMembershipById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}