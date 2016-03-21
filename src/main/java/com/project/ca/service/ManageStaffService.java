package com.project.ca.service;

import java.util.List;

import com.project.ca.exception.StaffNotFoundException;
import com.project.ca.model.LeaveForm;
import com.project.ca.model.Staff;


public interface ManageStaffService {

	//public String getstaffid(String firstname);
	public String checkpassword(String staffid, String password);
	public Staff create(Staff st);
	public Staff delete(String staffid) throws StaffNotFoundException;
	public Staff update(Staff s) throws StaffNotFoundException;
	public List<Staff> findAll();
	public Staff findById(String staffid);	
	//public List<Staff> findStaffByManagerID(String nickname);
	

}
