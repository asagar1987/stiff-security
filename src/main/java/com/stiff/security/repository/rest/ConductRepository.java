package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Conduct;

@RepositoryRestResource(collectionResourceRel = "conduct", path = "conduct")
public interface ConductRepository extends JpaRepository<Conduct, Integer>
{

}
