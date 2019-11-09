package com.project.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.beans.MachineBean;
import com.project.model.*;
import com.project.service.*;

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
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String name= userService.getUserByUsername(uname).getName();
		Map<String, Object> mod = new HashMap<String, Object>();

		if (userService.isAuthorized(uname, pass)) {
			mod.put("username", uname);
			session.setAttribute("uname", name);
			if (userService.isAdminByUserName(uname))
				return new ModelAndView("redirect:/admin", mod);
			else
				return new ModelAndView("redirect:/user", mod);
		} else
			return new ModelAndView("InvalidLogin");
	}
	
    @RequestMapping(value="/logout.html",method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
    	session.removeAttribute("uname");
    	session.invalidate();
    	return new ModelAndView("login");
    } 

	// Redirecting and Sending data to Admin page
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView getTimeSheetListAdmin() {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("timesheets", timeService.getTimesheets());
		mod.put("jobs", jobService.getAllJobs());
		mod.put("machines", machineService.getMachines());
		mod.put("tab", "jobs");
		return new ModelAndView("adminIndex", mod);
	}
	
	// Redirecting and Sending data to User page ( should know exactly what the user need )
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView getTimeSheetListUser() {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("timesheets", timeService.getTimesheets());
		mod.put("jobs", jobService.getAllJobs());
		mod.put("machines", machineService.getMachines());
		return new ModelAndView("userIndex", mod);
	}
	
	@RequestMapping(value = "/deletejob.html", method = RequestMethod.GET)
	public ModelAndView deleteJob(@RequestParam("id") Integer id) {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("tab", "jobs");
		jobService.removeJob(id);
		return new ModelAndView("redirect:/admin",mod);
	}

	@RequestMapping(value = "/deletemachine.html", method = RequestMethod.GET)
	public ModelAndView deleteMachine(@RequestParam("id") Integer id) {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("tab", "machines");
		machineService.delete(id);
		return new ModelAndView("redirect:/admin",mod);
	}
	

	@RequestMapping(value = "/newmachine.html", method = RequestMethod.GET)
	public ModelAndView newMachine(@ModelAttribute("command") Machine machine, BindingResult result) {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("machine", null);
		mod.put("tab", "machines");
		ModelAndView mv = new ModelAndView("NewMachineView", mod);
		return mv;
	}
	

	@RequestMapping(value = "/newjob.html", method = RequestMethod.GET)
	public ModelAndView newJob(@ModelAttribute("command") Job job, BindingResult result) {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("job", null);
		mod.put("tab", "jobs");
		ModelAndView mv = new ModelAndView("NewJobView", mod);
		return mv;
	}
	

	@RequestMapping(value = "/saveJob", method = RequestMethod.POST)
	public ModelAndView addJob(@ModelAttribute("command") Job job, BindingResult result) {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("tab", "jobs");
		jobService.saveJob(job);
		return new ModelAndView("redirect:/admin",mod);
	}

	@RequestMapping(value = "/saveMachine", method = RequestMethod.POST)
	public ModelAndView addMachine(@ModelAttribute("command") Machine machine, BindingResult result) {
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("tab", "machines");
		machineService.add(machine);
		return new ModelAndView("redirect:/admin",mod);
	}

	
	
	
	@RequestMapping(value = "/editmachine.html", method = RequestMethod.GET)
	public ModelAndView updateMachine(@ModelAttribute("command") Machine machine, BindingResult result) {
		Machine machineToUpdate = machineService.getMachineById(machine.getId());
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("machine", machineToUpdate);
		mod.put("tab", "machines");
		return new ModelAndView("NewMachineView", mod);
	}




	@RequestMapping(value = "/editjob.html", method = RequestMethod.GET)
	public ModelAndView updateJob(@ModelAttribute("command") Job job, BindingResult result,HttpServletRequest req) {
		int i = Integer.parseInt(req.getParameter("id"));
		Job jobToUpdate = jobService.getJobById(i);
		Map<String, Object> mod = new HashMap<String, Object>();
		mod.put("job", jobToUpdate);
		mod.put("tab", "jobs");
		return new ModelAndView("NewJobView", mod);
	}
	


}