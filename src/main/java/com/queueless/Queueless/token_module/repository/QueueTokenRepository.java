package com.queueless.Queueless.token_module.repository;

import com.queueless.Queueless.token_module.entity.QueueToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueTokenRepository
        extends JpaRepository<QueueToken, Long> {
}