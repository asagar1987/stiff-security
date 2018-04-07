package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.TimesheetWorkflow;

@RepositoryRestResource(collectionResourceRel = "timesheetWorkflow", path = "timesheetWorkflow")
public interface TimesheetWorkflowRepository extends JpaRepository<TimesheetWorkflow, Integer>
{

}
