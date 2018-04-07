package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.LeaveWorkflowStatus;

@RepositoryRestResource(collectionResourceRel = "leaveWorkflowStatus", path = "leaveWorkflowStatus")
public interface LeaveWorkflowStatusRepository extends JpaRepository<LeaveWorkflowStatus, Integer>
{

}
