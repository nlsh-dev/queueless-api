package com.queueless.Queueless.branch_module.service;

import com.queueless.Queueless.branch_module.dto.BranchCreateRequest;
import com.queueless.Queueless.branch_module.dto.BranchResponse;
import com.queueless.Queueless.branch_module.entity.Branch;
import com.queueless.Queueless.branch_module.repository.BranchRepository;
import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.organization_module.entity.Organization;
import com.queueless.Queueless.organization_module.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final OrganizationRepository organizationRepository;

    public ApiResponse<BranchResponse> createBranch(
            BranchCreateRequest request) {

        Organization organization =
                organizationRepository.findById(request.getOrganizationId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Organization not found with id: "
                                                + request.getOrganizationId()
                                ));

        Branch branch = new Branch();

        branch.setOrganization(organization);
        branch.setName(request.getName());
        branch.setAddressLine1(request.getAddressLine1());
        branch.setAddressLine2(request.getAddressLine2());
        branch.setCity(request.getCity());
        branch.setState(request.getState());
        branch.setPostalCode(request.getPostalCode());
        branch.setCountry(request.getCountry());
        branch.setTimezone(request.getTimezone());

        Branch savedBranch = branchRepository.save(branch);

        BranchResponse response = new BranchResponse();

        response.setId(savedBranch.getId());
        response.setOrganizationId(organization.getId());
        response.setName(savedBranch.getName());
        response.setAddressLine1(savedBranch.getAddressLine1());
        response.setAddressLine2(savedBranch.getAddressLine2());
        response.setCity(savedBranch.getCity());
        response.setState(savedBranch.getState());
        response.setPostalCode(savedBranch.getPostalCode());
        response.setCountry(savedBranch.getCountry());
        response.setTimezone(savedBranch.getTimezone());
        response.setStatus(savedBranch.getStatus());
        response.setCreatedAt(savedBranch.getCreatedAt());
        response.setUpdatedAt(savedBranch.getUpdatedAt());

        return ApiResponse.<BranchResponse>builder()
                .success(true)
                .message("Branch created successfully")
                .data(response)
                .build();
    }

    public ApiResponse<BranchResponse> getBranchById(Long id) {

        Branch branch = branchRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Branch not found with id: " + id
                        ));

        BranchResponse response = new BranchResponse();

        response.setId(branch.getId());
        response.setOrganizationId(branch.getOrganization().getId());
        response.setName(branch.getName());
        response.setAddressLine1(branch.getAddressLine1());
        response.setAddressLine2(branch.getAddressLine2());
        response.setCity(branch.getCity());
        response.setState(branch.getState());
        response.setPostalCode(branch.getPostalCode());
        response.setCountry(branch.getCountry());
        response.setTimezone(branch.getTimezone());
        response.setStatus(branch.getStatus());
        response.setCreatedAt(branch.getCreatedAt());
        response.setUpdatedAt(branch.getUpdatedAt());

        return ApiResponse.<BranchResponse>builder()
                .success(true)
                .message("Branch retrieved successfully")
                .data(response)
                .build();
    }
}