package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.MachineDAO;
import com.project.model.Machine;

@Component
public class MachineService {
	
    @Autowired MachineDAO repository;
    
    public void add(Machine machine) {
        repository.save(machine);
    }
    public void delete(int id) {
        repository.deleteById(id);
//    	repository.delete(machine);
    }
    public List<Machine> getMachines() {
        return (List<Machine>) repository.findAll();
    }
    public Optional<Machine> getMachineById(int id) {
    	return repository.findById(id);
    }

    
    @Transactional
    public void updateMachine (Machine machine) {
    	int id = machine.getId();
    	String code = machine.getCode();
    	String description = machine.getDescription();
    	double hourly_rent = machine.getHourly_rent();
    	double max_hours_per_day = machine.getMax_hours_per_day();
    	repository.editMachine(code, description, hourly_rent, max_hours_per_day, id);
    }
    

//    public void editMachine(@Param("code") String code,@Param("description") String description,
//    		@Param("hourly_rent") double hourly_rent, @Param("max_hours_per_day") double max_hours_per_day,
//    		@Param("id") int id);
    
    
    

//    public void editMachine(Machine machine) {
//    	Machine machineToUpdate = (Machine) repository.findById(machine.getId()).orElse(new Machine());
//    	machineToUpdate.setCode(machine.getCode());
//    	machineToUpdate.setDescription(machine.getDescription());
//    	machineToUpdate.setHourly_rent(machine.getHourly_rent());
//    	machineToUpdate.setMax_hours_per_day(machine.getMax_hours_per_day());
//    	repository.save(machineToUpdate);
//    	
//    }

}