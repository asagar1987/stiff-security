package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Timesheet;

@RepositoryRestResource(collectionResourceRel = "timesheet", path = "timesheet")
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer>
{

}
