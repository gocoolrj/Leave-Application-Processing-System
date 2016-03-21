package com.project.ca.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.exception.StaffNotFoundException;
import com.project.ca.model.Staff;
import com.project.ca.repository.StaffRepository;

@Service
public class ManageStaffServiceImp implements ManageStaffService {

	@Resource
	private StaffRepository staffref;
	@Resource
	private StaffRepository staffRepository;
	

	public String checkpassword(String staffid, String password) {

		String password1 = password;

		String tempstaff = staffid;
		String temp = "not found";
		if (password1.equals(staffref.findOne(tempstaff).getPwd())) {

			return (staffref.findOne(tempstaff).getFirstname());

		} else
			return temp;
	}
		
	@Override
	@Transactional
	public Staff create(Staff st) {
		Staff createdStaff = st;
		return staffRepository.save(createdStaff);
	}

	@Override
	@Transactional
	public Staff delete(String staffid) throws StaffNotFoundException {
		Staff deletedStaff = staffRepository.findOne(staffid);
		
		
		if (deletedStaff == null)
			throw new StaffNotFoundException();
		
		staffRepository.delete(deletedStaff);
		return deletedStaff;
	}

	@Override
	@Transactional
	public Staff update(Staff st) throws StaffNotFoundException {
		Staff updatedStaff = staffRepository.findOne(st.getStaffid());
		
		if (updatedStaff== null)
			throw new StaffNotFoundException();
		updatedStaff.setStaffid(st.getStaffid());
		updatedStaff.setRoleid(st.getRoleid());
		updatedStaff.setFirstname(st.getFirstname());
		updatedStaff.setLastname(st.getLastname());
		updatedStaff.setGender(st.getGender());
		updatedStaff.setAddress(st.getAddress());
		updatedStaff.setPhoneno(st.getPhoneno());
		updatedStaff.setEmail(st.getEmail());
		updatedStaff.setPwd(st.getPwd());
		updatedStaff.setManagerid(st.getManagerid());
		updatedStaff.setCreatedby(st.getCreatedby());
		updatedStaff.setCreateddate(st.getCreateddate());
		updatedStaff.setUpdatedby(st.getUpdatedby());
		updatedStaff.setUpdateddate(st.getUpdateddate());
		staffRepository.flush();
		return updatedStaff;
	}

	@Override
	public List<Staff> findAll() {
		
		List<Staff> stList = staffRepository.findAll();
		return stList;
	}

	@Override
	public Staff findById(String staffid) {
		// TODO Auto-generated method stub
		return staffRepository.findOne(staffid);
	}
	

}
