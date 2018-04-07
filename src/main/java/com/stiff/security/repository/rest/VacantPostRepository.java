package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.VacantPost;

@RepositoryRestResource(collectionResourceRel = "vacantPost", path = "vacantPost")
public interface VacantPostRepository extends JpaRepository<VacantPost, Integer>
{

}
