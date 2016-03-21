package com.project.ca.service;

import java.util.List;

import com.project.ca.model.Holiday;


public interface HolidayService {
	
	public Holiday create(Holiday h);
	public List<Holiday> findAll();
}
