package com.project.ca.service;

import com.project.ca.model.LeaveForm;
import com.project.ca.model.Staff;

import java.util.List;

public interface ApproveRejectService1 {

	public List<LeaveForm> getAppliedLeaveForms(String key);
	
	public Staff getStafffromStaffId(String staffid);

	public LeaveForm updateLeaveForm(int id,String status);
	
}
