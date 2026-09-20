package com.queueless.Queueless.service_module.service;

import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.service_module.dto.ServiceCreateRequest;
import com.queueless.Queueless.service_module.dto.ServiceResponse;
import com.queueless.Queueless.service_module.entity.Service;
import com.queueless.Queueless.service_module.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ApiResponse<ServiceResponse> createService(
            ServiceCreateRequest request) {

        Service service = new Service();

        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setAverageDurationMinutes(
                request.getAverageDurationMinutes()
        );

        Service savedService = serviceRepository.save(service);

        ServiceResponse response = new ServiceResponse();

        response.setId(savedService.getId());
        response.setName(savedService.getName());
        response.setDescription(savedService.getDescription());
        response.setAverageDurationMinutes(
                savedService.getAverageDurationMinutes()
        );
        response.setStatus(savedService.getStatus());
        response.setCreatedAt(savedService.getCreatedAt());
        response.setUpdatedAt(savedService.getUpdatedAt());

        return ApiResponse.<ServiceResponse>builder()
                .success(true)
                .message("Service created successfully")
                .data(response)
                .build();
    }

    public ApiResponse<ServiceResponse> getServiceById(Long id) {

        Service service = serviceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service not found with id: " + id
                        ));

        ServiceResponse response = new ServiceResponse();

        response.setId(service.getId());
        response.setName(service.getName());
        response.setDescription(service.getDescription());
        response.setAverageDurationMinutes(
                service.getAverageDurationMinutes()
        );
        response.setStatus(service.getStatus());
        response.setCreatedAt(service.getCreatedAt());
        response.setUpdatedAt(service.getUpdatedAt());

        return ApiResponse.<ServiceResponse>builder()
                .success(true)
                .message("Service retrieved successfully")
                .data(response)
                .build();
    }
}