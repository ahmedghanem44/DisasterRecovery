package com.project.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.model.User;
import com.project.service.UserService;

@Component
public class UserTest implements CommandLineRunner{

	@Autowired
	UserService userService;
	
    @Override
    public void run(String...args) throws Exception {
    	
        User u1 = new User();
        u1.setName("phil");
        u1.setUsername("philuser");
        u1.setIs_admin(false);        
        User u2 = new User();
        u2.setName("karen");
        u2.setUsername("karenuser");
        u2.setIs_admin(true);
        
        userService.add(u1);
        userService.add(u2);
        
        List<User> userlist = userService.getUsers();
        for(User u : userlist)
        	System.out.println(u);
        
        User u3 = userService.getUserById(userlist.get(0).getId());
        u3.setName("pete");
        u3.setUsername("peteuser");
        
        userService.add(u3);
        
        userlist = userService.getUsers();
        for(User u : userlist)
        {
        	System.out.println(u);
        	userService.delete(u.getId());
        }
        
    }
}
