package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.LeaveWorkflow;

@RepositoryRestResource(collectionResourceRel = "leaveWorkflow", path = "leaveWorkflow")
public interface LeaveWorkflowRepository extends JpaRepository<LeaveWorkflow, Integer>
{

}
