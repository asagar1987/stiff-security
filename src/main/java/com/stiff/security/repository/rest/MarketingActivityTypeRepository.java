package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.MarketingActivityType;

@RepositoryRestResource(collectionResourceRel = "marketingActivityTypes", path = "marketingActivityTypes")
public interface MarketingActivityTypeRepository extends JpaRepository<MarketingActivityType, Integer>
{

}
