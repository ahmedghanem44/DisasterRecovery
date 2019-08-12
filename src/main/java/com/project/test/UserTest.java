package com.project.test;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.model.Machine;
import com.project.model.Timesheet;
import com.project.service.MachineService;
import com.project.service.TimesheetService;
import com.project.service.UserService;

@Component
public class UserTest implements CommandLineRunner{

	@Autowired
	UserService userService;
	@Autowired
	MachineService machineService;	
	@Autowired
	TimesheetService timesheetService;
	
	
    @Override
    public void run(String...args) throws Exception {
    	if(args.length > 0)
    	{
    		

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
    		
    		m.setTimesheet(timesheet);
    		m2.setTimesheet(timesheet);
    		
    		machineService.add(m);
    		machineService.add(m2);
    		
    		timesheetService.add(timesheet);
    		
    		Timesheet t = timesheetService.getTimesheetById(timesheet.getId());
    		
    		Set<Machine> tm = t.getMachines();
    		
    		System.out.println(t);
    		
    		for (Machine mach : tm)
    			System.out.println(mach);
    		
    		
    	}
    }
}
