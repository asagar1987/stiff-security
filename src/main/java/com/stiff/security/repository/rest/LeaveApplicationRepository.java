package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.LeaveApplication;

@RepositoryRestResource(collectionResourceRel = "leaveApplication", path = "leaveApplication")
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer>
{

}
