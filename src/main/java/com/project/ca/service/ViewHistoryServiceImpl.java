	package com.project.ca.service;

	import java.sql.Date;
import java.util.List;










import javax.annotation.Resource;

	import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.exception.LeaveFormNotFound;
import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;
import com.project.ca.repository.LeaveFormRepository;
import com.project.ca.repository.LeaveTypeRepository;
import com.project.ca.repository.StaffRepository;

	@Service
	public class ViewHistoryServiceImpl implements ViewHistoryService {
		


	@Resource
	private LeaveFormRepository leaveformRepo;
	
	@Resource
	private LeaveTypeRepository leavetypeRepo;
	
	@Resource
	private StaffRepository staffRepo;
	
		@Override
		@Transactional
		public LeaveForm findRecordbyid(int leaveformid){
	    	
	    	return leaveformRepo.findOne(leaveformid);
	    	
		}
		@Override
		@Transactional
		public List<LeaveForm> findAll() {
			
			List<LeaveForm> leaveList = leaveformRepo.findAll();
			return leaveList;
		}
		@Override
		@Transactional
		public LeaveType findLeaveTypeById(int leaveid){
	    	
	    	return leavetypeRepo.findOne(leaveid);
	    	
		}
		@Override
		@Transactional
		public Staff findStaffInfoById(String staffid){
	    	
	    	return staffRepo.findOne(staffid);
	    	
		}
		
	
		@Override
		@Transactional
		public Staff updateContact(LeaveForm leaveform,String contact){
			
			LeaveForm Updtleave=leaveformRepo.findOne(leaveform.getLeaveformid());
			Staff Updtstaff=staffRepo.findOne(Updtleave.getStaffid());
			
			try{
				
			
			if(Updtstaff!=null){
				Updtstaff.setAddress(contact);
				staffRepo.flush();
			}
			}
			catch(Exception e){}
			return Updtstaff;
		}
		
		@Override
		@Transactional
		public LeaveForm updateLeaveid(LeaveForm leaveform,int leavetype){
			
			LeaveForm Updtleave=leaveformRepo.findOne(leaveform.getLeaveformid());
			if(Updtleave!=null){
				Updtleave.setLeaveid(leavetype);
				leaveformRepo.flush();
			}
			return Updtleave;
		}
		/*@Override
		@Transactional
		public LeaveForm deletestatus(LeaveForm leaveform)
		
		{
			
			LeaveForm deletestatus = leaveformRepo.findOne();
			
			
		}*/
		/*public LeaveForm update(LeaveForm leaveform)
		{
			LeaveForm updatestatus = leaveformRepo.findOne(leaveform.getLeaveformid());
				if (updatestatus != null)
				{
				updateform.setLeaveformid(form.getLeaveformid());
				updateform.setLeaveid(form.getLeaveid());
				updateform.setStaffid(form.getStaffid());
				updateform.setStartdate(form.getStartdate());
				updateform.setFromshift(form.getFromshift());
				updateform.setEnddate(form.getEnddate());
				updateform.setToshift(form.getToshift());
				updateform.setDaystaken(form.getDaystaken());
				updateform.setLstatus(form.getLstatus());
				
				
				String temp = updatestatus.getReason();
				updatestatus.setReason(temp);
					String temp =updateform.getReason();
				updateform.setReason(temp);
				
				updateform.setComment(form.getComment());
				updateform.setCreatedby(form.getCreatedby());
				updateform.setUpdatedby(form.getUpdatedby());
				updateform.setCreateddate(form.getCreateddate());
				updateform.setUpdateddate(form.getUpdateddate());
				leaveformRepo.flush();
				}
				return updatestatus;
			}*/
		@Override
		@Transactional
		public LeaveForm delete(int leaveformid) {
			System.out.println("ldelete page :" +  leaveformid);
			LeaveForm deletedLeaveform = leaveformRepo.findOne(leaveformid);
			
			if(deletedLeaveform!=null){
				leaveformRepo.delete(deletedLeaveform);
			}
			return deletedLeaveform;
		}
		/*@Override
		@Transactional
		public LeaveType deleteType(String lstatus){
			System.out.println("ldelete type :" +  lstatus);
			LeaveType deletedLeaveType = leavetypeRepo.findOne()
			
			if(deletedLeaveType!=null){
				leavetypeRepo.delete(deletedLeaveType);
			}
			return deletedLeaveType*/;
		
		@Override
		@Transactional
		public LeaveForm create(LeaveForm leaveform) {
			System.out.println("CREATE : " + leaveform.toString());
			LeaveForm createdlform = leaveform;
			return leaveformRepo.save(createdlform);
			
		}
		/*@Override
		@Transactional
		public LeaveType createType(LeaveType leavetype) {
			System.out.println("CREATE : " + leavetype.toString());
			LeaveType createdltype = leavetype;
			return leavetypeRepo.save(createdltype);
			
		}*/
		/*public LeaveForm delete(LeaveForm leaveform)
		{
			
			LeaveForm deleteform = leaveformRepo.findOne(leaveform.getLeaveformid());
			if(deleteform != null)
			{
				deleteform.setLeaveformid(0);
				deleteform.setLeaveid(0);
				deleteform.setStaffid(" ");
				deleteform.setStartdate();
				deleteform.setFromshift(" ");
				deleteform.setEnddate(0);
				deleteform.setToshift(" ");
				deleteform.setDaystaken(0);
				deleteform.setLstatus(" ");
				deleteform.setReason(" ");
				deleteform.setComment(" ");
				deleteform.setCreatedby(" ");
				deleteform.setCreateddate(" ");
				deleteform.setUpdatedby(" ");
				deleteform.setUpdateddate(" ");
				
				
			}*/
	//	}
		public LeaveForm cancelLeave(LeaveForm leaveform,String cancel){
			
			LeaveForm cancelform = leaveformRepo.findOne(leaveform.getLeaveformid());

		    if(cancelform!=null){
		    	cancelform.setLstatus(cancel);
		    	leaveformRepo.flush();
		    }
		    return cancelform;
			
		}
	
		}


