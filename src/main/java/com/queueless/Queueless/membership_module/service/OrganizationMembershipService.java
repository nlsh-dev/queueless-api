package com.queueless.Queueless.membership_module.service;

import com.queueless.Queueless.User_Module.entity.User;
import com.queueless.Queueless.User_Module.repository.UserRepository;
import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.membership_module.dto.OrganizationMembershipCreateRequest;
import com.queueless.Queueless.membership_module.dto.OrganizationMembershipResponse;
import com.queueless.Queueless.membership_module.entity.OrganizationMembership;
import com.queueless.Queueless.membership_module.repository.OrganizationMembershipRepository;
import com.queueless.Queueless.organization_module.entity.Organization;
import com.queueless.Queueless.organization_module.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationMembershipService {

    private final OrganizationMembershipRepository membershipRepository;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;

    public ApiResponse<OrganizationMembershipResponse> createMembership(
            OrganizationMembershipCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Organization organization = organizationRepository
                .findById(request.getOrganizationId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Organization not found"));

        OrganizationMembership membership = new OrganizationMembership();

        membership.setUser(user);
        membership.setOrganization(organization);
        membership.setRole(request.getRole());

        OrganizationMembership saved =
                membershipRepository.save(membership);

        OrganizationMembershipResponse response =
                new OrganizationMembershipResponse();

        response.setId(saved.getId());
        response.setUserId(user.getId());
        response.setOrganizationId(organization.getId());
        response.setRole(saved.getRole());
        response.setStatus(saved.getStatus());

        return ApiResponse.<OrganizationMembershipResponse>builder()
                .success(true)
                .message("Membership created successfully")
                .data(response)
                .build();
    }

    public ApiResponse<OrganizationMembershipResponse> getMembershipById(Long id) {

        OrganizationMembership membership =
                membershipRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Membership not found with id: " + id));

        OrganizationMembershipResponse response =
                new OrganizationMembershipResponse();

        response.setId(membership.getId());
        response.setUserId(membership.getUser().getId());
        response.setOrganizationId(membership.getOrganization().getId());
        response.setRole(membership.getRole());
        response.setStatus(membership.getStatus());

        return ApiResponse.<OrganizationMembershipResponse>builder()
                .success(true)
                .message("Membership retrieved successfully")
                .data(response)
                .build();
    }
}