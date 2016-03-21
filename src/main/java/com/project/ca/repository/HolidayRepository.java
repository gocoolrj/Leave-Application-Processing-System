package com.project.ca.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.project.ca.model.*;

public interface HolidayRepository extends JpaRepository<Holiday,Integer> {

	
}
