package com.project.ca.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;
import com.project.ca.repository.LeaveFormRepository;
import com.project.ca.repository.LeaveTypeRepository;
import com.project.ca.repository.StaffRepository;

@Service
public class ManageReportServiceImpl implements ManageReportService{


	@Resource 
	private  LeaveFormRepository leaveR;
	
	@Resource
	private LeaveTypeRepository leavetype;

	@Resource
	private StaffRepository staffdetail;
	
	
	@Override
	@Transactional
	public List<LeaveForm> LeaveReports(int leaveid, Date startdate,
			Date enddate) {
		
		return leaveR.findReportList(leaveid, startdate, enddate);
	}

	

	@Override
	@Transactional
	public Staff findstaffbyid(String staffid){
		
		Staff staff=staffdetail.findOne(staffid);
		
		return staff;
		
	}
	
	@Override
	@Transactional
	public LeaveType findbyleaveid(int leaveid){
		
		LeaveType leavename=leavetype.findOne(leaveid);
				
		return leavename;
	}

	
}

