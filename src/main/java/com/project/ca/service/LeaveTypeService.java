package com.project.ca.service;

import java.util.List;

import com.project.ca.model.LeaveType;

public interface LeaveTypeService {
	
	public LeaveType create(LeaveType lt);
	public LeaveType update(LeaveType lt);
	public LeaveType delete(int id);
	public List<LeaveType> findAll();
	public LeaveType findById(int id);

}
