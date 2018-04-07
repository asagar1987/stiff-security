package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Worklocation;

@RepositoryRestResource(collectionResourceRel = "worklocation", path = "worklocation")
public interface WorklocationRepository extends JpaRepository<Worklocation, Integer>
{

}
