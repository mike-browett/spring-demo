package com.example.usermgmt.dto;

import com.example.usermgmt.entity.UserEntity.ActiveStatus;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class UserResponseDto {
    private Long objNr;
    private String id;
    private String firstname;
    private String lastname;
    private ZonedDateTime creationDate;
    private ActiveStatus active;
}
