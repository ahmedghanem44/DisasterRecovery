package com.project.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.model.Machine;
import com.project.model.User;
import com.project.service.MachineService;
import com.project.service.UserService;

@Component
public class UserTest implements CommandLineRunner{

	@Autowired
	UserService userService;
	@Autowired
	MachineService machineService;
	
    @Override
    public void run(String...args) throws Exception {
    	if(args.length > 0)
    	{
    		

    		Machine m = new Machine();
    		m.setCode("AT-1300");
    		m.setDescription("something");
    		m.setHourly_rent(5.55);
    		m.setMax_hours_per_day(7.5);
	        
    		machineService.add(m);
    		
    		List<Machine> mlist = machineService.getMachines();
    		
    		for (Machine mach: mlist)
    			System.out.println(mach);
    		machineService.delete(m.getId());
    	}
    }
}
