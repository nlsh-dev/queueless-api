package com.queueless.Queueless.appointment_module.controller;

import com.queueless.Queueless.appointment_module.dto.AppointmentCreateRequest;
import com.queueless.Queueless.appointment_module.dto.AppointmentResponse;
import com.queueless.Queueless.appointment_module.service.AppointmentService;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<AppointmentResponse>> createAppointment(
            @Valid @RequestBody AppointmentCreateRequest request) {

        ApiResponse<AppointmentResponse> response =
                appointmentService.createAppointment(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AppointmentResponse>> getAppointmentById(
            @PathVariable Long id) {

        ApiResponse<AppointmentResponse> response =
                appointmentService.getAppointmentById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}