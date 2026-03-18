package com.example.usermgmt.service;

import com.example.usermgmt.dto.UserFilterDto;
import com.example.usermgmt.dto.UserRequestDto;
import com.example.usermgmt.dto.UserResponseDto;
import com.example.usermgmt.entity.UserEntity;
import com.example.usermgmt.exception.ResourceNotFoundException;
import com.example.usermgmt.filter.UserSpecificationBuilder;
import com.example.usermgmt.mapper.UserMapper;
import com.example.usermgmt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserSpecificationBuilder specBuilder;

    @Override
    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        if (userRepository.existsByIdIgnoreCase(request.getId())) {
            throw new IllegalArgumentException("User with id '" + request.getId() + "' already exists");
        }
        UserEntity entity = userMapper.toEntity(request);
        return userMapper.toResponseDto(userRepository.save(entity));
    }

    @Override
    public UserResponseDto findByObjNr(Long objNr) {
        return userMapper.toResponseDto(requireUser(objNr));
    }

    @Override
    public Page<UserResponseDto> findAll(UserFilterDto filter, Pageable pageable) {
        Specification<UserEntity> spec = specBuilder.build(filter);
        return userRepository.findAll(spec, pageable).map(userMapper::toResponseDto);
    }

    @Override
    @Transactional
    public UserResponseDto update(Long objNr, UserRequestDto request) {
        UserEntity existing = requireUser(objNr);
        userMapper.updateEntityFromDto(request, existing);
        return userMapper.toResponseDto(userRepository.save(existing));
    }

    @Override
    @Transactional
    public void delete(Long objNr) {
        userRepository.delete(requireUser(objNr));
    }

    private UserEntity requireUser(Long objNr) {
        return userRepository.findById(objNr)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with objNr: " + objNr));
    }
}
