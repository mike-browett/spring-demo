package com.example.usermgmt.service;

import com.example.usermgmt.dto.UserFilterDto;
import com.example.usermgmt.dto.UserRequestDto;
import com.example.usermgmt.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponseDto create(UserRequestDto request);
    UserResponseDto findByObjNr(Long objNr);
    Page<UserResponseDto> findAll(UserFilterDto filter, Pageable pageable);
    UserResponseDto update(Long objNr, UserRequestDto request);
    void delete(Long objNr);
}
