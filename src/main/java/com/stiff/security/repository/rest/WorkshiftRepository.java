package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Workshift;

@RepositoryRestResource(collectionResourceRel = "workshift", path = "workshift")
public interface WorkshiftRepository extends JpaRepository<Workshift, Integer>
{

}
