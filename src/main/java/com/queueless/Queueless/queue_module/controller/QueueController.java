package com.queueless.Queueless.queue_module.controller;

import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.queue_module.dto.QueueCreateRequest;
import com.queueless.Queueless.queue_module.dto.QueueResponse;
import com.queueless.Queueless.queue_module.service.QueueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/queues")
@RequiredArgsConstructor
public class QueueController {

    private final QueueService queueService;

    @PostMapping
    public ResponseEntity<ApiResponse<QueueResponse>> createQueue(
            @Valid @RequestBody QueueCreateRequest request) {

        ApiResponse<QueueResponse> response =
                queueService.createQueue(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<QueueResponse>> getQueueById(
            @PathVariable Long id) {

        ApiResponse<QueueResponse> response =
                queueService.getQueueById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}