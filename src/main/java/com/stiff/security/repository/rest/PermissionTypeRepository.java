package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.PermissionType;

@RepositoryRestResource(collectionResourceRel = "permissionTypes", path = "permissionTypes")
public interface PermissionTypeRepository extends JpaRepository<PermissionType, Integer>
{

}
