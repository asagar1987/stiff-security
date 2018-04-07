package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.ContactType;

@RepositoryRestResource(collectionResourceRel = "contactTypes", path = "contactTypes")
public interface ContactTypeRepository extends JpaRepository<ContactType, Integer>
{

}
