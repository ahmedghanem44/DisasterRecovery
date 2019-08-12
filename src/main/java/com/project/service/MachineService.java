package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.MachineDAO;
import com.project.model.Machine;

@Component
public class MachineService {
	
    @Autowired MachineDAO repository;
    
    public void add(Machine machine) {
        repository.save(machine);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Machine> getMachines() {
        return (List<Machine>) repository.findAll();
    }
    public Machine getMachineById(long id) {
    	return (Machine) repository.findById(id).orElse(new Machine());
    }

}