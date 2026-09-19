package com.queueless.Queueless.organization_module.controller;

import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import com.queueless.Queueless.organization_module.dto.OrganizationCreateRequest;
import com.queueless.Queueless.organization_module.dto.OrganizationResponse;
import com.queueless.Queueless.organization_module.entity.Organization;
import com.queueless.Queueless.organization_module.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;




    //create organization
    public ApiResponse<OrganizationResponse> createOrganization(
            OrganizationCreateRequest request) {

        Organization organization =
                modelMapper.map(request, Organization.class);

        Organization savedOrganization =
                organizationRepository.save(organization);

        OrganizationResponse response =
                modelMapper.map(savedOrganization, OrganizationResponse.class);

        return ApiResponse.<OrganizationResponse>builder()
                .success(true)
                .message("Organization created successfully")
                .data(response)
                .build();
    }




    // get by id
    public ApiResponse<OrganizationResponse> getOrganizationById(Long id) {

        Organization organization =
                organizationRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Organization not found with id: " + id
                                ));

        OrganizationResponse response =
                modelMapper.map(organization, OrganizationResponse.class);

        return ApiResponse.<OrganizationResponse>builder()
                .success(true)
                .message("Organization retrieved successfully")
                .data(response)
                .build();
    }
}