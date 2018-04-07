package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.AddressType;

@RepositoryRestResource(collectionResourceRel = "addressTypes", path = "addressTypes")
public interface AddressTypeRepository extends JpaRepository<AddressType, Integer>
{
	
}
