package com.project.ca.service;

import java.util.List;

import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;

public interface ManageLeaveService {
	

	
	public LeaveForm findRecordbyid(int staffid);
	
	public LeaveForm delete(int leaveformid);
	
	public LeaveForm update(LeaveForm update);
	
	public List<LeaveForm> findbystaffid(String staffid);

	public LeaveType findbyleaveid(int leaveid);
	
	public Staff findstaffbyid(String staffid);
	
	public Staff updateContact(LeaveForm update,String contact);
	
	public LeaveForm updateLeaveid(LeaveForm update,int leavetype);
	
	public LeaveForm cancelLeave(LeaveForm update,String cancel);
	
	/*public List<LeaveForm> findRecordbyStaffID(String staffID);*/

}
