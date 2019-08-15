package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Job;
import com.project.model.JobHours;
import com.project.model.Machine;
import com.project.model.MachineUse;
import com.project.model.Timesheet;
import com.project.service.JobHoursService;
import com.project.service.JobService;
import com.project.service.MachineService;
import com.project.service.MachineUseService;
import com.project.service.TimesheetService;
import com.project.service.UserService;

@Controller
public class TimesheetAddController {
	

	@Autowired
	private JobService jobService;
	@Autowired
	private JobHoursService jobHours;
	
	@Autowired
	private MachineService machineService;
	@Autowired
	private MachineUseService machineUseService;
	
	@Autowired
	private TimesheetService timesheetService;
	
	@Autowired
	private UserService userService;
	

    @GetMapping("/timesheetForm")
    public ModelAndView root() {
    	
    	Map<String,Object> mod = new HashMap<String,Object>();
    	mod.put("machines" , machineService.getMachines());
    	mod.put("jobs" , jobService.getAllJobs());
        return new ModelAndView("timesheetInput", mod);

    }
  
    @PostMapping("/saveTimesheet")
    public ModelAndView saveTimesheet(@RequestBody Map<String, Object> map) {

    	Timesheet timesheet = new Timesheet();
    	timesheet.setDate((String)map.get("date"));
    	timesheet.setSite_code((String)map.get("site_code"));
    	timesheet.setContractor_name((String)map.get("contractor_name"));
    	timesheet.setIsOpen(true);

    	
    	List<Map<String, Object>> machine_list = (List<Map<String, Object>>)map.get("machines");
    	for(Map<String, Object> mo : machine_list)
    	{
    		Machine m = machineService.getMachineById((int)mo.get("id"));
    		MachineUse mu = new MachineUse();
    		mu.setHours_used((double)mo.get("hours"));
    		mu.setMachine(m);
    		mu.setTimesheet(timesheet);
    		timesheet.addMachineUse(mu);
    		timesheetService.add(timesheet);
    		machineUseService.add(mu);
    	}
    	
    	List<Map<String, Object>> labor_list = (List<Map<String, Object>>)map.get("labor");	
    	for(Map<String, Object> jo : labor_list)
    	{
    		Job j = jobService.getJobById((int)jo.get("id"));
    		JobHours jh = new JobHours();
    		jh.setHours_worked((double)jo.get("hours"));
    		jh.setJob(j);
    		jh.setTimesheet(timesheet);
    		timesheet.addJobHours(jh);
    		timesheetService.add(timesheet);
    		jobHours.add(jh);
    	}
		timesheet.setTotalHours();
		timesheet.setTotalAmount();
		timesheetService.add(timesheet);
    	
    	return new ModelAndView("adminIndex");
    }
    
}   
    
  