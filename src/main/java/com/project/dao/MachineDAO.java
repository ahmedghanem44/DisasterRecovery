package com.project.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Machine;

public interface MachineDAO extends CrudRepository<Machine, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("update Machine m set m.code= :code , m.description= :description, m.hourly_rent= :hourly_rent,"
			+ "m.max_hours_per_day= :max_hours_per_day where m.id= :id ")
	void editMachine(@Param("code") String code, @Param("description") String description,
			@Param("hourly_rent") double hourly_rent, @Param("max_hours_per_day") double max_hours_per_day,
			@Param("id") int id);




}