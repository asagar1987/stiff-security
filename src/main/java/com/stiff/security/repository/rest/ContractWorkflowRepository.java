package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.ContractWorkflow;

@RepositoryRestResource(collectionResourceRel = "contractWorkflow", path = "contractWorkflow")
public interface ContractWorkflowRepository extends JpaRepository<ContractWorkflow, Integer>
{

}
