package com.example.usermgmt.mapper;

import com.example.usermgmt.dto.UserRequestDto;
import com.example.usermgmt.dto.UserResponseDto;
import com.example.usermgmt.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-18T10:37:52+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( dto.getId() );
        userEntity.firstname( dto.getFirstname() );
        userEntity.lastname( dto.getLastname() );
        userEntity.active( dto.getActive() );

        return userEntity.build();
    }

    @Override
    public UserResponseDto toResponseDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setObjNr( entity.getObjNr() );
        userResponseDto.setId( entity.getId() );
        userResponseDto.setFirstname( entity.getFirstname() );
        userResponseDto.setLastname( entity.getLastname() );
        userResponseDto.setCreationDate( entity.getCreationDate() );
        userResponseDto.setActive( entity.getActive() );

        return userResponseDto;
    }

    @Override
    public void updateEntityFromDto(UserRequestDto dto, UserEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getFirstname() != null ) {
            entity.setFirstname( dto.getFirstname() );
        }
        if ( dto.getLastname() != null ) {
            entity.setLastname( dto.getLastname() );
        }
        if ( dto.getActive() != null ) {
            entity.setActive( dto.getActive() );
        }
    }
}
