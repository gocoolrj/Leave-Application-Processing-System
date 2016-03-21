package com.project.ca.service;

import java.sql.Date;
import java.util.List;

import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;

public interface ManageReportService {
	

	/*public LeaveArchives FindOne(int id);
	
	public LeaveArchives Update(LeaveArchives a);
	
	public List<LeaveArchives> ReportsAll(Date startDate, Date endDate);
	
	public List<LeaveArchives> filterDataByAppliedStatus(String status, String manager);
	*/
	public List<LeaveForm> LeaveReports(int leaveid, Date startdate, Date enddate);
	
    public LeaveType findbyleaveid(int leaveid);
	
	public Staff findstaffbyid(String staffid);

}
