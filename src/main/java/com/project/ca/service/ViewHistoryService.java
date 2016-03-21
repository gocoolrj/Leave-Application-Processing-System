	package com.project.ca.service;

	import java.util.List;

import com.project.ca.exception.LeaveFormNotFound;
import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;




	public interface ViewHistoryService {

		public LeaveForm findRecordbyid(int leaveformid);
		public List<LeaveForm> findAll();
		public LeaveType findLeaveTypeById(int leaveid);
		
		public Staff updateContact(LeaveForm update,String contact);
		public LeaveForm updateLeaveid(LeaveForm update,int leavetype);
		
		
		public Staff findStaffInfoById(String staffid);
/*		public LeaveForm deletestatus(LeaveForm leaveform);*/
		/*public LeaveForm update(LeaveForm leaveform);*/
		/*public LeaveForm create(LeaveForm leaveform);*/
		public LeaveForm delete(int leaveformid);
		
		/*public LeaveForm delete(LeaveForm leaveform);*/
		/*public LeaveForm delete(int leaveformid) throws LeaveFormNotFound;*/
		public LeaveForm create(LeaveForm leaveform);
	/*	public LeaveType deleteType(int leaveid);
		public LeaveType createType(LeaveType leaveType);*/
	/*	
		public LeaveType deleteType(String lstatus);*/
		
		public LeaveForm cancelLeave(LeaveForm leaveform,String cancel);
		

	}