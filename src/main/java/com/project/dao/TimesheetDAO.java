package com.project.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.model.Timesheet;

public interface TimesheetDAO extends CrudRepository<Timesheet, Long> {
	
	// To get the total hours worked by all labors in one timesheet
	double getTotalHours(int id);
	
	// To get the total amount by multiplying hours worked by the labor hourly rate for all the labors
    // in one timesheet 
	double getTotalAmount(int id);
	
	// To finalize and approve the timesheet ad set isOpen status to false
	void approveTimeSheet(int id);
}