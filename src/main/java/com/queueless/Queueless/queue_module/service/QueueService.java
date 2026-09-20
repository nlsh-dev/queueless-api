package com.queueless.Queueless.queue_module.service;

import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.queue_module.dto.QueueCreateRequest;
import com.queueless.Queueless.queue_module.dto.QueueResponse;
import com.queueless.Queueless.queue_module.entity.Queue;
import com.queueless.Queueless.queue_module.repository.QueueRepository;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class QueueService {

    private final QueueRepository queueRepository;

    public ApiResponse<QueueResponse> createQueue(
            QueueCreateRequest request) {

        Queue queue = new Queue();

        queue.setServiceId(request.getServiceId());
        queue.setQueueDate(request.getQueueDate());

        Queue savedQueue = queueRepository.save(queue);

        QueueResponse response = new QueueResponse();

        response.setId(savedQueue.getId());
        response.setServiceId(savedQueue.getServiceId());
        response.setQueueDate(savedQueue.getQueueDate());
        response.setStatus(savedQueue.getStatus());
        response.setNextTokenNumber(savedQueue.getNextTokenNumber());
        response.setCreatedAt(savedQueue.getCreatedAt());
        response.setUpdatedAt(savedQueue.getUpdatedAt());

        return ApiResponse.<QueueResponse>builder()
                .success(true)
                .message("Queue created successfully")
                .data(response)
                .build();
    }

    public ApiResponse<QueueResponse> getQueueById(Long id) {

        Queue queue = queueRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Queue not found with id: " + id
                        ));

        QueueResponse response = new QueueResponse();

        response.setId(queue.getId());
        response.setServiceId(queue.getServiceId());
        response.setQueueDate(queue.getQueueDate());
        response.setStatus(queue.getStatus());
        response.setNextTokenNumber(queue.getNextTokenNumber());
        response.setCreatedAt(queue.getCreatedAt());
        response.setUpdatedAt(queue.getUpdatedAt());

        return ApiResponse.<QueueResponse>builder()
                .success(true)
                .message("Queue retrieved successfully")
                .data(response)
                .build();
    }
}