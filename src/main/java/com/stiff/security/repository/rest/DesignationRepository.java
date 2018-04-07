package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Designation;

@RepositoryRestResource(collectionResourceRel = "designation", path = "designation")
public interface DesignationRepository extends JpaRepository<Designation, Integer>
{

}
