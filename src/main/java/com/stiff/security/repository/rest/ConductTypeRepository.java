package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.ConductType;

@RepositoryRestResource(collectionResourceRel = "conductTypes", path = "conductTypes")
public interface ConductTypeRepository extends JpaRepository<ConductType, Integer>
{

}
