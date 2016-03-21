package com.project.ca.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.ca.Home;
import com.project.ca.repository.StaffRepository;

@Service
public class StaffServiceImp implements StaffService {
	private static final Logger logger = LoggerFactory.getLogger(Home.class);
	@Resource
	private StaffRepository staffref;

	public int checkpassword(String staffid, String password) {

		String password1 = password;
		if (staffref.findOne(staffid)!= null) {
			if (password1
					.equalsIgnoreCase((staffref.findOne(staffid).getPwd()))) {
				logger.info(staffref.findOne(staffid).getPwd());
				return (staffref.findOne(staffid).getRoleid());
			} else
				return 0;
		}
		return 5;
	}

}
