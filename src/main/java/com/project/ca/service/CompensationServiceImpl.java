package com.project.ca.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.LeaveForm;
import com.project.ca.repository.LeaveFormRepository;

@Service
public class CompensationServiceImpl implements CompensationService {
	
	@Resource LeaveFormRepository lfrr;
	@Override
	@Transactional
	public LeaveForm createcompensation(LeaveForm lf)
	{
		return lfrr.save(lf);
	}
}
