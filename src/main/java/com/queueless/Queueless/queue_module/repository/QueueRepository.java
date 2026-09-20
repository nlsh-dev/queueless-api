package com.queueless.Queueless.queue_module.repository;

import com.queueless.Queueless.queue_module.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long> {
}