package com.queueless.Queueless.token_module.controller;

import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.token_module.dto.QueueTokenCreateRequest;
import com.queueless.Queueless.token_module.dto.QueueTokenResponse;
import com.queueless.Queueless.token_module.service.QueueTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tokens")
@RequiredArgsConstructor
public class QueueTokenController {

    private final QueueTokenService queueTokenService;

    @PostMapping
    public ResponseEntity<ApiResponse<QueueTokenResponse>> createQueueToken(
            @Valid @RequestBody QueueTokenCreateRequest request) {

        ApiResponse<QueueTokenResponse> response =
                queueTokenService.createQueueToken(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<QueueTokenResponse>> getQueueTokenById(
            @PathVariable Long id) {

        ApiResponse<QueueTokenResponse> response =
                queueTokenService.getQueueTokenById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}