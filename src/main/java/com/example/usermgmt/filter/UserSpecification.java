package com.example.usermgmt.filter;

import com.example.usermgmt.entity.UserEntity;
import com.example.usermgmt.entity.UserEntity.ActiveStatus;
import org.springframework.data.jpa.domain.Specification;

import java.time.ZonedDateTime;

/**
 * Library of atomic JPA Specification predicates for UserEntity.
 *
 * HOW TO ADD A NEW FILTER CONDITION:
 *   1. Add a static method here returning Specification<UserEntity>.
 *   2. Add the filter field to UserFilterDto.
 *   3. Register the condition in UserSpecificationBuilder.build().
 */
public class UserSpecification {

    private UserSpecification() {}

    public static Specification<UserEntity> hasId(String id) {
        return (root, query, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification<UserEntity> firstnameLike(String firstname) {
        return (root, query, cb) ->
            cb.like(cb.lower(root.get("firstname")), "%" + firstname.toLowerCase() + "%");
    }

    public static Specification<UserEntity> lastnameLike(String lastname) {
        return (root, query, cb) ->
            cb.like(cb.lower(root.get("lastname")), "%" + lastname.toLowerCase() + "%");
    }

    public static Specification<UserEntity> hasActiveStatus(ActiveStatus active) {
        return (root, query, cb) -> cb.equal(root.get("active"), active);
    }

    public static Specification<UserEntity> createdAfter(ZonedDateTime dateTime) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("creationDate"), dateTime);
    }

    public static Specification<UserEntity> createdBefore(ZonedDateTime dateTime) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("creationDate"), dateTime);
    }
}
