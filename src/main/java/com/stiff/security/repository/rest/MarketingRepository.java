package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.Marketing;

@RepositoryRestResource(collectionResourceRel = "marketing", path = "marketing")
public interface MarketingRepository extends JpaRepository<Marketing, Integer>
{

}
