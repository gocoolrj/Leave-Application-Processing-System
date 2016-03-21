package com.project.ca.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.Role;

public interface RoleService {

	public Role create(Role r);
	public Role update(Role r);
	public Role delete(int id);
	public List<Role> findAll();
	public Role findById(int id);
	
}
