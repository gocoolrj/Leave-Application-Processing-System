package com.project.ca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;
import com.project.ca.service.ManageReportService;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
	
	@Autowired
	private ManageReportService LeaveRepsvc;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@RequestMapping(value = "/leave", method = RequestMethod.GET)
	public String home(Model model) {		
		return "Manager/RecordFind";	
	}
	
	@RequestMapping(value = "/leave", method = RequestMethod.POST)
	public String home(@RequestParam("leaveid")int leaveid, @RequestParam("startdate") Date startdate, @RequestParam("enddate") Date enddate) 
			throws IOException {
			List<LeaveForm> list = LeaveRepsvc.LeaveReports(leaveid, startdate, enddate);
			java.util.Date today = new java.util.Date();
		    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			FileWriter fw = new FileWriter("d:/ViewLeaveRecords"+df.format(today)+".csv");
			PrintWriter pw = new PrintWriter(fw);
			for(LeaveForm a : list){
				LeaveType leaveType=LeaveRepsvc.findbyleaveid(a.getLeaveid());				
				Staff staff=LeaveRepsvc.findstaffbyid(a.getStaffid());
			    
				pw.print(leaveType.getLeavetype());
			    pw.print(',');
			    pw.print(staff.getFirstname());
			    pw.print(',');
			    pw.print(staff.getGender());
			    pw.print(',');
			    pw.print(a.getStartdate());
			    pw.print(',');
			    pw.print(a.getEnddate());
			    pw.print(',');
			    pw.print(a.getDaystaken());
			    pw.print(',');
			    pw.print(a.getReason());
			    pw.print(',');
			    pw.print(a.getLstatus());
			    pw.print(',');
			    pw.print(staff.getAddress());
			    pw.print(',');
			    pw.print(staff.getPhoneno());
			    
				pw.flush();				
				pw.println();
			
			pw.close();
		}
			return "Manager/Manager";
		
	}
}

