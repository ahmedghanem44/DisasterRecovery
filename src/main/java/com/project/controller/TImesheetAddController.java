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
public class TImesheetAddController {
	
	@Autowired
	private JobService jobService;
	@Autowired
	private JobHoursService jobHours;
	
	@Autowired
	private MachineService machineService;
	@Autowired
	private MachineUseService machineUseService;
	
	@Autowired
	private TimesheetService timeService;
	
	@Autowired
	private UserService userService;
	

    @GetMapping("/timesheetAdd")
    public ModelAndView root() {
        ModelAndView mv = new ModelAndView("timesheetInput");
        return mv;
    }
  
    
    
}   
    
  