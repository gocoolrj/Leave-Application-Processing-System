package com.project.ca.service;

import java.text.SimpleDateFormat;
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
public class ManageLeaveServiceImpl implements ManageLeaveService {
	
	
@Resource
private LeaveFormRepository leaveform;

@Resource
private LeaveTypeRepository leavetype;

@Resource
private StaffRepository staffdetail;

@Resource
private StaffRepository staffref;
	
	/*@Override
	@Transactional
	public List<LeaveForm> findRecordbyStaffID(String staffID){
		System.out.println("ManageLeave : " + staffID);
		List<LeaveForm> lfList= leaveform.
		return lfList;
	}*/


	@Override
	@Transactional
	public LeaveForm findRecordbyid(int leaveformid ){
    	
    	LeaveForm leave = leaveform.findOne(leaveformid);
    	
    	return leave;
    }
	
	@Override
	@Transactional
	public List<LeaveForm> findbystaffid(String staffid){
		
		List<LeaveForm> leave=leaveform.find(staffid);
		
		return leave;
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

	@Override
	@Transactional
	public LeaveForm delete(int leaveformid)  {
	
    LeaveForm leave = leaveform.findOne(leaveformid);
		
	leaveform.delete(leave);
	return leave;
	}
	
	@Override
	@Transactional
	public LeaveForm update(LeaveForm update){
		
		LeaveForm Updtleave=leaveform.findOne(update.getLeaveformid());
		if(Updtleave!=null){
		Updtleave.setStartdate(update.getStartdate());
		Updtleave.setEnddate(update.getEnddate());
		Updtleave.setFromshift(update.getFromshift());
		Updtleave.setToshift(update.getToshift());
		Updtleave.setReason(update.getReason());
		Updtleave.setLstatus(update.getLstatus());
        Updtleave.setWorkdissemination(update.getWorkdissemination()); 
		leaveform.flush();
		} 
		return Updtleave;
	}
	
	@Override
	@Transactional
	public Staff updateContact(LeaveForm update,String contact){
		
		LeaveForm Updtleave=leaveform.findOne(update.getLeaveformid());
		Staff Updtstaff=staffdetail.findOne(Updtleave.getStaffid());
		if(Updtstaff!=null){
			Updtstaff.setAddress(contact);
			staffdetail.flush();
		}
		return Updtstaff;
	}
	
	@Override
	@Transactional
	public LeaveForm updateLeaveid(LeaveForm update,int leavetype){
		
		LeaveForm Updtleave=leaveform.findOne(update.getLeaveformid());
		if(Updtleave!=null){
			Updtleave.setLeaveid(leavetype);
			leaveform.flush();
		}
		return Updtleave;
	}
	
	@Override
	@Transactional
	public LeaveForm cancelLeave(LeaveForm update,String cancel){
		
		LeaveForm Cancleave=leaveform.findOne(update.getLeaveformid());
		if(Cancleave!=null){
			Cancleave.setLstatus(cancel);
		    leaveform.flush();
		}
		return Cancleave;
	}
}
