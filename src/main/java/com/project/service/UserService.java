package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.UserDAO;
import com.project.model.Machine;
import com.project.model.User;

@Component
public class UserService {
	
    @Autowired UserDAO repository;
    
    public void add(User user) {
        repository.save(user);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<User> getUsers() {
        return (List<User>) repository.findAll();
    }
    public User getUserById(long id) {
    	return (User) repository.findById(id).orElse(new User());
    }

}