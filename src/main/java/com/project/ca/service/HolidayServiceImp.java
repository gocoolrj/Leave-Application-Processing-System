package com.project.ca.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.Holiday;
import com.project.ca.model.Staff;
import com.project.ca.repository.HolidayRepository;

@Service
public class HolidayServiceImp implements HolidayService{
	
	@Resource
	private HolidayRepository holidayRepository;

	@Override
	@Transactional
	public Holiday create(Holiday h) {
		Holiday createdHoliday = h;
		return holidayRepository.save(createdHoliday);
	}

	@Override
	public List<Holiday> findAll() {
		List<Holiday> hList = holidayRepository.findAll();
		return hList;
	}

}
