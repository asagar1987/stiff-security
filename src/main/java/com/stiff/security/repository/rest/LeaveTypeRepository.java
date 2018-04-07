package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.LeaveType;

@RepositoryRestResource(collectionResourceRel = "leaveType", path = "leaveType")
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer>
{

}
