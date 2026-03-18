package com.example.usermgmt.mapper;

import com.example.usermgmt.dto.UserRequestDto;
import com.example.usermgmt.dto.UserResponseDto;
import com.example.usermgmt.entity.UserEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {

    UserEntity toEntity(UserRequestDto dto);

    UserResponseDto toResponseDto(UserEntity entity);

    @Mapping(target = "objNr", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    void updateEntityFromDto(UserRequestDto dto, @MappingTarget UserEntity entity);
}
