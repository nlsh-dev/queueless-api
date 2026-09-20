package com.queueless.Queueless.token_module.service;

import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.token_module.dto.QueueTokenCreateRequest;
import com.queueless.Queueless.token_module.dto.QueueTokenResponse;
import com.queueless.Queueless.token_module.entity.QueueToken;
import com.queueless.Queueless.token_module.repository.QueueTokenRepository;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class QueueTokenService {

    private final QueueTokenRepository queueTokenRepository;

    public ApiResponse<QueueTokenResponse> createQueueToken(
            QueueTokenCreateRequest request) {

        QueueToken token = new QueueToken();

        token.setQueueId(request.getQueueId());
        token.setUserId(request.getUserId());
        token.setAppointmentId(request.getAppointmentId());
        token.setTokenNumber(request.getTokenNumber());

        QueueToken savedToken =
                queueTokenRepository.save(token);

        QueueTokenResponse response =
                new QueueTokenResponse();

        response.setId(savedToken.getId());
        response.setQueueId(savedToken.getQueueId());
        response.setUserId(savedToken.getUserId());
        response.setAppointmentId(savedToken.getAppointmentId());
        response.setTokenNumber(savedToken.getTokenNumber());
        response.setStatus(savedToken.getStatus());
        response.setJoinedAt(savedToken.getJoinedAt());
        response.setCalledAt(savedToken.getCalledAt());
        response.setServiceStartedAt(savedToken.getServiceStartedAt());
        response.setCompletedAt(savedToken.getCompletedAt());
        response.setCancelledAt(savedToken.getCancelledAt());
        response.setCreatedAt(savedToken.getCreatedAt());
        response.setUpdatedAt(savedToken.getUpdatedAt());

        return ApiResponse.<QueueTokenResponse>builder()
                .success(true)
                .message("Queue token created successfully")
                .data(response)
                .build();
    }

    public ApiResponse<QueueTokenResponse> getQueueTokenById(Long id) {

        QueueToken token =
                queueTokenRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Queue token not found with id: " + id
                                ));

        QueueTokenResponse response =
                new QueueTokenResponse();

        response.setId(token.getId());
        response.setQueueId(token.getQueueId());
        response.setUserId(token.getUserId());
        response.setAppointmentId(token.getAppointmentId());
        response.setTokenNumber(token.getTokenNumber());
        response.setStatus(token.getStatus());
        response.setJoinedAt(token.getJoinedAt());
        response.setCalledAt(token.getCalledAt());
        response.setServiceStartedAt(token.getServiceStartedAt());
        response.setCompletedAt(token.getCompletedAt());
        response.setCancelledAt(token.getCancelledAt());
        response.setCreatedAt(token.getCreatedAt());
        response.setUpdatedAt(token.getUpdatedAt());

        return ApiResponse.<QueueTokenResponse>builder()
                .success(true)
                .message("Queue token retrieved successfully")
                .data(response)
                .build();
    }
}