package com.example.usermgmt.dto;

import com.example.usermgmt.entity.UserEntity.ActiveStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {

    @NotBlank(message = "Id must not be blank")
    @Size(max = 100)
    private String id;

    @Size(max = 100)
    private String firstname;

    @Size(max = 100)
    private String lastname;

    @NotNull(message = "Active status is required")
    private ActiveStatus active;
}
