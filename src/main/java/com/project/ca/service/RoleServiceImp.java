package com.project.ca.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.SimpleAliasRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.Role;
import com.project.ca.repository.RoleRepository;


@Service
public class RoleServiceImp implements RoleService{

	@Resource
	private RoleRepository roleref;

	@Override
	@Transactional
	public Role create(Role r) {
		Role createdRole = r;
		return roleref.save(createdRole);
	}

	@Override
	@Transactional
	public Role update(Role r) {
		
		
		Role updatedRole = roleref.findOne(r.getRoleid());
		if(updatedRole != null){
			updatedRole.setTitle(r.getTitle());
			updatedRole.setCreatedby(r.getCreatedby());
			updatedRole.setCreateddate(r.getCreateddate());
			updatedRole.setUpdatedby(r.getCreatedby());
			updatedRole.setUpdateddate(r.getUpdateddate());
			roleref.flush();			
		}
		
		return null;
	}

	@Override
	@Transactional
	public Role delete(int id) {
		Role deletedRole = roleref.findOne(id);
		
		if(deletedRole!=null){
			roleref.delete(deletedRole);
		}
		return deletedRole;
	}

	@Override
	@Transactional
	public List<Role> findAll() {
		return roleref.findAll();
	}

	@Override
	@Transactional
	public Role findById(int id) {
		return roleref.findOne(id);
	}




	

}
