package com.queueless.Queueless.User_Module.controller;

import com.queueless.Queueless.User_Module.dto.user.UserCreateRequest;
import com.queueless.Queueless.User_Module.dto.user.UserResponse;
import com.queueless.Queueless.User_Module.service.UserService;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(
            @Valid @RequestBody UserCreateRequest request) {

        ApiResponse<UserResponse> response =
                userService.createUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(
            @PathVariable Long id) {

        ApiResponse<UserResponse> response =
                userService.getUserById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}