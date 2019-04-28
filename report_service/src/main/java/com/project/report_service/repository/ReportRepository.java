package com.project.report_service.repository;

import com.project.report_service.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    List<Report> findAllByDateContains(Date date);
    List<Report> findAll();
}
