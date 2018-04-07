package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.ActivityLogEntry;

@RepositoryRestResource(collectionResourceRel = "audit", path = "audit")
public interface ActivityLogEntryRepository extends JpaRepository<ActivityLogEntry, Integer>
{

}
