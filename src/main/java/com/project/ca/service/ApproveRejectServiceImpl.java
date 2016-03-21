package com.project.ca.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.LeaveForm;
import  com.project.ca.model.Staff;




import com.project.ca.repository.LeaveFormRepository;
import com.project.ca.repository.StaffRepository;


@Service
public class ApproveRejectServiceImpl implements ApproveRejectService {
	
	@Resource
	private LeaveFormRepository repos;
	@Resource
	private StaffRepository staffrepos;

	@Override
	public List<LeaveForm> getAppliedLeaveForms(String key) {
		// TODO Auto-generated method stub
		
		return repos.getAppliedLeaveForms(key);
	}

	@Override
	public Staff getStafffromStaffId(String staffid) {
		// TODO Auto-generated method stub
		return staffrepos.findOne(staffid);
	}

	
	@Override
	@Transactional
	public LeaveForm updateLeaveForm(int id,String status) {
		// TODO Auto-generated method stub
		LeaveForm obj = repos.findOne(id);
		obj.setLstatus(status);
		//obj.setLstatus("Approved");
		repos.flush();
		return obj;
	}
	
	
	

}
