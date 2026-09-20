package com.queueless.Queueless.appointment_module.service;

import com.queueless.Queueless.appointment_module.dto.AppointmentCreateRequest;
import com.queueless.Queueless.appointment_module.dto.AppointmentResponse;
import com.queueless.Queueless.appointment_module.entity.Appointment;
import com.queueless.Queueless.appointment_module.repository.AppointmentRepository;
import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public ApiResponse<AppointmentResponse> createAppointment(
            AppointmentCreateRequest request) {

        Appointment appointment = new Appointment();

        appointment.setUserId(request.getUserId());
        appointment.setServiceId(request.getServiceId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setStartTime(request.getStartTime());
        appointment.setEndTime(request.getEndTime());
        appointment.setNotes(request.getNotes());

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        AppointmentResponse response =
                new AppointmentResponse();

        response.setId(savedAppointment.getId());
        response.setUserId(savedAppointment.getUserId());
        response.setServiceId(savedAppointment.getServiceId());
        response.setAppointmentDate(
                savedAppointment.getAppointmentDate()
        );
        response.setStartTime(savedAppointment.getStartTime());
        response.setEndTime(savedAppointment.getEndTime());
        response.setStatus(savedAppointment.getStatus());
        response.setNotes(savedAppointment.getNotes());
        response.setCreatedAt(savedAppointment.getCreatedAt());
        response.setUpdatedAt(savedAppointment.getUpdatedAt());
        response.setCancelledAt(savedAppointment.getCancelledAt());

        return ApiResponse.<AppointmentResponse>builder()
                .success(true)
                .message("Appointment created successfully")
                .data(response)
                .build();
    }

    public ApiResponse<AppointmentResponse> getAppointmentById(Long id) {

        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Appointment not found with id: " + id
                                ));

        AppointmentResponse response =
                new AppointmentResponse();

        response.setId(appointment.getId());
        response.setUserId(appointment.getUserId());
        response.setServiceId(appointment.getServiceId());
        response.setAppointmentDate(
                appointment.getAppointmentDate()
        );
        response.setStartTime(appointment.getStartTime());
        response.setEndTime(appointment.getEndTime());
        response.setStatus(appointment.getStatus());
        response.setNotes(appointment.getNotes());
        response.setCreatedAt(appointment.getCreatedAt());
        response.setUpdatedAt(appointment.getUpdatedAt());
        response.setCancelledAt(appointment.getCancelledAt());

        return ApiResponse.<AppointmentResponse>builder()
                .success(true)
                .message("Appointment retrieved successfully")
                .data(response)
                .build();
    }
}