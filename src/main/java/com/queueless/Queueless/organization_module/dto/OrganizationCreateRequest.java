package com.queueless.Queueless.organization_module.dto;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationCreateRequest {


    @NotBlank(message = "Name is  required ")
    @Size(max = 100, message = "name must note exceed 100 characters ")
    private String name;


    @Size( max =  500 , message = "Description must not exceed 500 charcters")
    private  String description;





}
