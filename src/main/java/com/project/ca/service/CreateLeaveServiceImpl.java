package com.project.ca.service;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ca.model.LeaveForm;
import com.project.ca.repository.LeaveFormRepository;
@Service
public class CreateLeaveServiceImpl implements CreateLeaveService  {
	@Resource LeaveFormRepository lfrrs;
	
	@Override
	@Transactional
	public LeaveForm CreateLeave(LeaveForm lfs)
	{ 
	long diff;
	
				 Date d2=lfs.getStartdate();
			System.out.println( d2);
		Date d3=lfs.getEnddate();
	
	
		System.out.println( d3);
			if((d3.compareTo(d2)>0))
			{
			diff= d3.getTime() - d2.getTime();
			float diffdays=(diff/86400000);
			if( diffdays<=14){
			lfs.setDaystaken(diffdays);
				System.out.println(diffdays);
		return lfrrs.save(lfs);
			}
			else if(diffdays<=18){
				lfs.setDaystaken(diffdays);
				return lfrrs.save(lfs);
				
			}
			else if(diffdays<=60)
				lfs.setDaystaken(diffdays);
			lfs.setLeaveid(4);
				return lfrrs.save(lfs);
			}
			else
			{
				lfs.setLstatus("rejected");
				System.out.println("rr");
				return lfrrs.save(lfs);
			}
	}

}
