package com.queueless.Queueless.organization_module.controller;

import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.organization_module.dto.OrganizationCreateRequest;
import com.queueless.Queueless.organization_module.dto.OrganizationResponse;
import com.queueless.Queueless.organization_module.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService service;

    @PostMapping
    public ResponseEntity<ApiResponse<OrganizationResponse>> createOrganization(
            @Valid @RequestBody OrganizationCreateRequest request) {

        ApiResponse<OrganizationResponse> response =
                service.createOrganization(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrganizationResponse>> getOrganizationById(
            @PathVariable Long id) {

        ApiResponse<OrganizationResponse> response =
                service.getOrganizationById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}