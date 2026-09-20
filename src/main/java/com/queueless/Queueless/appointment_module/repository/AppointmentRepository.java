package com.queueless.Queueless.appointment_module.repository;

import com.queueless.Queueless.appointment_module.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {
}