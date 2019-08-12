package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.TimesheetDAO;
import com.project.model.Timesheet;

@Component
public class TimesheetService {
	
    @Autowired TimesheetDAO repository;
    
    public void add(Timesheet timesheet) {
        repository.save(timesheet);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Timesheet> getTimesheets() {
        return (List<Timesheet>) repository.findAll();
    }
    public Timesheet getTimesheetById(long id) {
        Optional<Timesheet> optionalTimesheet = repository.findById(id);
        return optionalTimesheet.orElseThrow();
    }

}