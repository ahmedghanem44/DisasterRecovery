package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.JobRepository;
import com.project.model.Job;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	public Job getJobById(int id) {
		return (Job) jobRepo.findById(id).orElse(new Job());
	}
	
	public void saveJob(Job job) {
		jobRepo.save(job);
	}
	
	public void removeJob(int id) {
//		if(jobRepo.existsById(id)) {
			jobRepo.deleteById(id);
//		}else {
//			
//		}
	}
	
	public List<Job> getAllJobs(){
		return (List<Job>) jobRepo.findAll();
	}

}
