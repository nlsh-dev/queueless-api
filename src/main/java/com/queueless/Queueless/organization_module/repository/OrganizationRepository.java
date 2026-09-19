package com.queueless.Queueless.organization_module.repository;

import com.queueless.Queueless.organization_module.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository  extends JpaRepository<Organization, Long> {
}
