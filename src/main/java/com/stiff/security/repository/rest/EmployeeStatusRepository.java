package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.EmployeeStatus;

@RepositoryRestResource(collectionResourceRel = "employeeStatus", path = "employeeStatus")
public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, Integer>
{

}
