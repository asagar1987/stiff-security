package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Contact;

@RepositoryRestResource(collectionResourceRel = "contact", path = "contact")
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

}
