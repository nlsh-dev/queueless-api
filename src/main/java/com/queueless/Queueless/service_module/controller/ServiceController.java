package com.queueless.Queueless.service_module.controller;

import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.service_module.dto.ServiceCreateRequest;
import com.queueless.Queueless.service_module.dto.ServiceResponse;
import com.queueless.Queueless.service_module.service.ServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ApiResponse<ServiceResponse>> createService(
            @Valid @RequestBody ServiceCreateRequest request) {

        ApiResponse<ServiceResponse> response =
                serviceService.createService(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ServiceResponse>> getServiceById(
            @PathVariable Long id) {

        ApiResponse<ServiceResponse> response =
                serviceService.getServiceById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}