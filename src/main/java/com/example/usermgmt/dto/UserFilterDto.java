package com.example.usermgmt.dto;

import com.example.usermgmt.entity.UserEntity.ActiveStatus;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * All fields are optional. Non-null values are ANDed together as filter conditions.
 * To add a new filter: add a field here, a predicate in UserSpecification,
 * and register it in UserSpecificationBuilder.
 */
@Data
public class UserFilterDto {
    private String id;
    private String firstname;
    private String lastname;
    private ActiveStatus active;
    private ZonedDateTime createdAfter;
    private ZonedDateTime createdBefore;
}
