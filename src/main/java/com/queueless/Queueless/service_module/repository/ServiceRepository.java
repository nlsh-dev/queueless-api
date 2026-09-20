package com.queueless.Queueless.service_module.repository;

import com.queueless.Queueless.service_module.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}