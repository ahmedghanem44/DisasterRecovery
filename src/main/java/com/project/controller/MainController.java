package com.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.JobHoursService;
import com.project.service.JobService;
import com.project.service.MachineService;
import com.project.service.MachineUseService;
import com.project.service.TimesheetService;
import com.project.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private JobService jobService;
	@Autowired
	private JobHoursService jobHours;
	
	@Autowired
	private MachineService machineService;
	@Autowired
	private MachineUseService machineUse;
	
	@Autowired
	private TimesheetService timeService;
	
	@Autowired
	private UserService userService;
	

    @GetMapping("/")
    public ModelAndView root() {
        ModelAndView mv = new ModelAndView("timesheetAdd");
        return mv;
    }
    
    @RequestMapping(value="/joblist",method= RequestMethod.GET)
    public ModelAndView getJobList() {
    	Map<String,Object> mod = new HashMap<String,Object>();
    	mod.put("jobs", jobService.getAllJobs());
    	return new ModelAndView("JobManagementView",mod);
    }
    
    @RequestMapping(value="/machinelist", method = RequestMethod.GET)
    public ModelAndView getMachineList() {
    	Map<String,Object> mod = new HashMap<String,Object>();
    	mod.put("machines" , machineService.getMachines());
    	return new ModelAndView("MachineManagementView",mod);
    }
    
    

}