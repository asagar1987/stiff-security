package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Contract;

@RepositoryRestResource(collectionResourceRel = "contract", path = "contract")
public interface ContractRepository extends JpaRepository<Contract, Integer>
{

}
