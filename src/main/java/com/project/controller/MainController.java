package com.project.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Job;
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
    
    @RequestMapping(value="/timesheetlist" , method = RequestMethod.GET)
    public ModelAndView getTimeSheetList() {
    	Map<String,Object> mod = new HashMap<String,Object>();
    	mod.put("timesheets", timeService.getTimesheets());
    	return new ModelAndView("timesheetAdd" , mod);
    }
    
    @RequestMapping(value="/login" , method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String uname ,@RequestParam("password") 
    String pass,HttpSession session) {
    	Map<String,Object> mod = new HashMap<String,Object>();
    	if (userService.isAuthorized(uname, pass)) {
    		mod.put("username", uname);
    		session.setAttribute("uname", uname);
    		if (userService.isAdminByUserName(uname)) 
    			return new ModelAndView("JobManagementView",mod);
    		else 
    			return new ModelAndView("TimeSheetView",mod);
    	}else
    		return new ModelAndView("error");
    }
    
    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
    	session.removeAttribute("uname");
    	session.invalidate();
    	return "redirect:/login.html";
    }
    
    @RequestMapping(value="/addJob" , method = RequestMethod.POST)
    public String addJob(@ModelAttribute("command") Job job , BindingResult result) {
    	jobService.saveJob(job);
    	return "redirect:/joblist.html";
    }
    
//    @RequestMapping(value="/deleteJob" , method = RequestMethod.POST)
//    public String deleteJob(@ModelAttribute("command")  , BindingResult result) {
//    	jobService.removeJob();
//    	return "redirect:/joblist.html";
//    }
    
    
    

}