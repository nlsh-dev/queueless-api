package com.queueless.Queueless.membership_module.repository;

import com.queueless.Queueless.membership_module.entity.OrganizationMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationMembershipRepository
        extends JpaRepository<OrganizationMembership, Long> {
}