package com.queueless.Queueless.branch_module.repository;

import com.queueless.Queueless.branch_module.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}