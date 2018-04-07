package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.MenuItem;

@RepositoryRestResource(collectionResourceRel = "menuItems", path = "menuItems")
public interface MenuItemsRepository extends JpaRepository<MenuItem, Integer>
{

}
