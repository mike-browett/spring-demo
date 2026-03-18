package com.example.usermgmt.repository;

import com.example.usermgmt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<UserEntity, Long>,
                JpaSpecificationExecutor<UserEntity> {

    Optional<UserEntity> findByIdIgnoreCase(String id);

    boolean existsByIdIgnoreCase(String id);
}
