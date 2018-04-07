package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.WorklocationType;

@RepositoryRestResource(collectionResourceRel = "worklocationTypes", path = "worklocationTypes")
public interface WorklocationTypeRepository extends JpaRepository<WorklocationType, Integer>
{

}
