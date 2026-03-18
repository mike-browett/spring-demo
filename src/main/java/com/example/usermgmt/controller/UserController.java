package com.example.usermgmt.controller;

import com.example.usermgmt.dto.UserFilterDto;
import com.example.usermgmt.dto.UserRequestDto;
import com.example.usermgmt.dto.UserResponseDto;
import com.example.usermgmt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "User management endpoints")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new user")
    public UserResponseDto create(@Valid @RequestBody UserRequestDto request) {
        return userService.create(request);
    }

    @GetMapping("/{objNr}")
    @Operation(summary = "Find a user by ObjNr")
    public UserResponseDto findByObjNr(@PathVariable Long objNr) {
        return userService.findByObjNr(objNr);
    }

    @GetMapping
    @Operation(summary = "List users with optional filters and pagination")
    public Page<UserResponseDto> findAll(
            @ParameterObject UserFilterDto filter,
            @ParameterObject @PageableDefault(size = 20, sort = "objNr") Pageable pageable) {
        return userService.findAll(filter, pageable);
    }

    @PutMapping("/{objNr}")
    @Operation(summary = "Update an existing user")
    public UserResponseDto update(
            @PathVariable Long objNr,
            @Valid @RequestBody UserRequestDto request) {
        return userService.update(objNr, request);
    }

    @DeleteMapping("/{objNr}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a user")
    public void delete(@PathVariable Long objNr) {
        userService.delete(objNr);
    }
}
