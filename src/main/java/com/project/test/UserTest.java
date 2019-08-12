package com.project.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.model.Job;
import com.project.service.JobService;
import com.project.service.MachineService;
import com.project.service.TimesheetService;
import com.project.service.UserService;

@Component
public class UserTest implements CommandLineRunner {

	@Autowired
	UserService userService;
	@Autowired
	MachineService machineService;
	@Autowired
	TimesheetService timesheetService;
	@Autowired
	JobService jobService;


	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {

			Job job = new Job();
			
	
			
			
			
			  Machine m = new Machine(); 
			  m.setCode("AT-1300");
			  m.setDescription("something"); 
			  m.setHourly_rent(5.55);
			  m.setMax_hours_per_day(7.5);
			  
			  Machine m2 = new Machine(); 
			  m2.setCode("NJ-90");
			  m2.setDescription("nothing"); 
			  m2.setHourly_rent(9.99);
			  m2.setMax_hours_per_day(2.0);
			  
			  Timesheet timesheet = new Timesheet(); 
			  timesheet.setContractor_name("petey");
			  timesheet.setDate("9/22/19"); 
			  timesheet.setSite_code("gg-22");
			  
			  
			  machineService.add(m); machineService.add(m2);
			  
			  MachineUse machineuse = new MachineUse(); 
			  machineuse.setHours_used(4.0);
			  machineuse.setMachine(m);
			  
			  timesheet.addMachineUse(machineuse);
			  
			  timesheetService.add(timesheet);
			  
			  Timesheet t = timesheetService.getTimesheetById(timesheet.getId());
			  
			  Set<MachineUse> mulist = t.getMachineuses();
			  
			  System.out.println(t);
			  
			  for (MachineUse mu : mulist) System.out.println(mu);
			 

		}
	}
}
