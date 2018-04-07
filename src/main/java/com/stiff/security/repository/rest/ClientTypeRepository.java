package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.ClientType;

@RepositoryRestResource(collectionResourceRel = "clientTypes", path = "clientTypes")
public interface ClientTypeRepository extends JpaRepository<ClientType, Integer>
{

}
