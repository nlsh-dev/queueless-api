package com.queueless.Queueless.User_Module.service;

import com.queueless.Queueless.User_Module.dto.user.UserCreateRequest;
import com.queueless.Queueless.User_Module.dto.user.UserResponse;
import com.queueless.Queueless.User_Module.entity.User;
import com.queueless.Queueless.User_Module.repository.UserRepository;
import com.queueless.Queueless.common_infrastructure.exception.DuplicateResourceException;
import com.queueless.Queueless.common_infrastructure.exception.ResourceNotFoundException;
import com.queueless.Queueless.common_infrastructure.response.ApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public ApiResponse<UserResponse> createUser(UserCreateRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException(
                    "Email is already registered"
            );
        }

        if (request.getPhone() != null &&
                userRepository.existsByPhone(request.getPhone())) {

            throw new DuplicateResourceException(
                    "Phone number is already registered"
            );
        }

        User user = modelMapper.map(request, User.class);

        // Temporary until security is implemented
        user.setPasswordHash(request.getPassword());

        User savedUser = userRepository.save(user);

        UserResponse userResponse =
                modelMapper.map(savedUser, UserResponse.class);

        return ApiResponse.<UserResponse>builder()
                .success(true)
                .message("User created successfully")
                .data(userResponse)
                .build();
    }


    @Transactional(Transactional.TxType.SUPPORTS)
    public ApiResponse<UserResponse> getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id
                        )
                );

        UserResponse userResponse =
                modelMapper.map(user, UserResponse.class);

        return ApiResponse.<UserResponse>builder()
                .success(true)
                .message("User retrieved successfully")
                .data(userResponse)
                .build();
    }
}