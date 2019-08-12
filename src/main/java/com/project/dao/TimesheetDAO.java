package com.project.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.model.Timesheet;

public interface TimesheetDAO extends CrudRepository<Timesheet, Long> {

}