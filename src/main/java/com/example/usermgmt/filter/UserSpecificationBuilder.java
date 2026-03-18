package com.example.usermgmt.filter;

import com.example.usermgmt.dto.UserFilterDto;
import com.example.usermgmt.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

/**
 * Builds a composite JPA Specification from a UserFilterDto.
 * All non-null filter fields are ANDed together.
 */
@Component
public class UserSpecificationBuilder {

    public Specification<UserEntity> build(UserFilterDto filter) {
        Specification<UserEntity> spec = Specification.where(null);

        if (filter == null) {
            return spec;
        }

        if (filter.getId() != null && !filter.getId().isBlank()) {
            spec = spec.and(UserSpecification.hasId(filter.getId()));
        }
        if (filter.getFirstname() != null && !filter.getFirstname().isBlank()) {
            spec = spec.and(UserSpecification.firstnameLike(filter.getFirstname()));
        }
        if (filter.getLastname() != null && !filter.getLastname().isBlank()) {
            spec = spec.and(UserSpecification.lastnameLike(filter.getLastname()));
        }
        if (filter.getActive() != null) {
            spec = spec.and(UserSpecification.hasActiveStatus(filter.getActive()));
        }
        if (filter.getCreatedAfter() != null) {
            spec = spec.and(UserSpecification.createdAfter(filter.getCreatedAfter()));
        }
        if (filter.getCreatedBefore() != null) {
            spec = spec.and(UserSpecification.createdBefore(filter.getCreatedBefore()));
        }

        return spec;
    }
}
