package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.EventType;

@RepositoryRestResource(collectionResourceRel = "eventTypes", path = "eventTypes")
public interface EventTypeRepository extends JpaRepository<EventType, Integer>
{

}
