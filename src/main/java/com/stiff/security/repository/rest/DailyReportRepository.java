package com.stiff.security.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stiff.security.entity.base.DailyReport;

@RepositoryRestResource(collectionResourceRel = "dailyReport", path = "dailyReport")
public interface DailyReportRepository extends JpaRepository<DailyReport, Integer>
{

}
