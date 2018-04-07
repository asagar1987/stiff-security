package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Overtime;

@RepositoryRestResource(collectionResourceRel = "overtime", path = "overtime")
public interface OvertimeRepository extends JpaRepository<Overtime, Integer>
{

}
