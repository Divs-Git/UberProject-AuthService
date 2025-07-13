package com.example.uberprojectauthservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "created_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate // this annotation tells that only handle it for object creation
    protected Date createdAt;

    @Column(name = "updated_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // this annotation tells that only handle it for object update
    protected Date updatedAt;
}