package com.example.usermgmt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "users", indexes = {
    @Index(name = "idx_users_id", columnList = "id", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_obj_nr_seq", allocationSize = 1)
    @Column(name = "obj_nr")
    private Long objNr;

    @Column(name = "id", nullable = false, unique = true, length = 100)
    private String id;

    @Column(name = "firstname", length = 100)
    private String firstname;

    @Column(name = "lastname", length = 100)
    private String lastname;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "active", nullable = false, length = 3)
    private ActiveStatus active;

    public enum ActiveStatus {
        YES, NO
    }
}
