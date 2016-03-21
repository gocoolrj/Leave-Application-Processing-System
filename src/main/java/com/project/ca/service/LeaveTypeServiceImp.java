package com.project.ca.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.LeaveType;
import com.project.ca.repository.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImp implements LeaveTypeService{

	@Resource
	private LeaveTypeRepository ltRep;
	
	@Override
	@Transactional
	public LeaveType create(LeaveType lt) {
		LeaveType createdLt = lt;		
		return ltRep.save(createdLt);
	}

	@Override
	@Transactional
	public LeaveType update(LeaveType lt) {
		
		LeaveType updatedLt = ltRep.findOne(lt.getLeaveid());
		if(updatedLt != null){
			updatedLt.setLeavetype(lt.getLeavetype());
			updatedLt.setLimitdays(lt.getLimitdays());
			updatedLt.setCreatedby(lt.getCreatedby());
			updatedLt.setCreateddate(lt.getCreateddate());
			updatedLt.setUpdatedby(lt.getUpdatedby());
			updatedLt.setUpdateddate(lt.getUpdateddate());
			ltRep.flush();
		}
		return null;
	}

	@Override
	@Transactional
	public LeaveType delete(int id) {
		LeaveType deletedLt = ltRep.findOne(id);
		if(deletedLt!=null){
			ltRep.delete(deletedLt);
		}
		return deletedLt;
	}

	@Override
	@Transactional
	public List<LeaveType> findAll() {
		return ltRep.findAll();
	}

	@Override
	@Transactional
	public LeaveType findById(int id) {
		return ltRep.findOne(id);
	}

}
