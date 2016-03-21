package com.project.ca.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.project.ca.model.*;

public interface RoleRepository extends JpaRepository<Role,Integer> {
	
}
