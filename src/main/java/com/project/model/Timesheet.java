package com.project.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Timesheets")
public class Timesheet implements Serializable {


	private static final long serialVersionUID = -6529528701780212425L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="timesheet")
    private Set<MachineUse> machineuses = new HashSet<MachineUse>();
	
	// added by Nemo
	@OneToMany(fetch = FetchType.EAGER, mappedBy="timesheet")
    private Set<JobHours> jobHours = new HashSet<JobHours>();
	

	public Set<JobHours> getJobHours() {
		return jobHours;
	}

	public void setJobHours(Set<JobHours> jobHours) {
		this.jobHours = jobHours;
	}
	// end of change

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "site_code")
	private String site_code;
	
	@Column(name = "contractor_name")
	private String contractor_name;
	
	// added by Nemo
	
	// Status of a timesheet to show if its either approved or not yet
	@Column (name="is_Open")
	private boolean isOpen;
	

	
	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Timesheet()
	{
	}	
	
	// end of change
	
	@Override
	public String toString() 
	{
		return	"date : " + date + 
				"\nsite code : " + site_code +
				"\ncontractor name: " + contractor_name +
				"\nnum machines: " + machineuses.size();
	}

	


	public Set<MachineUse> getMachineuses() {
		return machineuses;
	}

	public void setMachineuses(Set<MachineUse> machineuses) {
		this.machineuses = machineuses;
	}

	public void addMachineUse(MachineUse machineuse) {
		machineuse.setTimesheet(this);
		machineuses.add(machineuse);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSite_code() {
		return site_code;
	}

	public void setSite_code(String site_code) {
		this.site_code = site_code;
	}

	public String getContractor_name() {
		return contractor_name;
	}

	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}



}
