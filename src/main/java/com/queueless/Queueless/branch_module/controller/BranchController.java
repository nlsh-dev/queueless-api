package com.queueless.Queueless.branch_module.controller;

import com.queueless.Queueless.branch_module.dto.BranchCreateRequest;
import com.queueless.Queueless.branch_module.dto.BranchResponse;
import com.queueless.Queueless.branch_module.service.BranchService;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<ApiResponse<BranchResponse>> createBranch(
            @Valid @RequestBody BranchCreateRequest request) {

        ApiResponse<BranchResponse> response =
                branchService.createBranch(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BranchResponse>> getBranchById(
            @PathVariable Long id) {

        ApiResponse<BranchResponse> response =
                branchService.getBranchById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}