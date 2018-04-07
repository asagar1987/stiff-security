package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.TimesheetStatus;

@RepositoryRestResource(collectionResourceRel = "timesheetStatus", path = "timesheetStatus")
public interface TimesheetStatusRepository extends JpaRepository<TimesheetStatus, Integer>
{

}
