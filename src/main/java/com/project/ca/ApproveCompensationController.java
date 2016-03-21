package com.project.ca;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.ca.model.LeaveForm;
import com.project.ca.model.Staff;
import com.project.ca.service.ApproveRejectService;

@Controller
@RequestMapping(value="/leave")
public class ApproveCompensationController {
	@Autowired
	private ApproveRejectService service;
	private static final Logger logger = LoggerFactory.getLogger(ApproveCompensationController.class);

	@RequestMapping(value = "/leave", method = RequestMethod.GET)
	public String leave(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		List<LeaveForm> listofleaveforms = service.getAppliedLeaveForms("applied1");
		
		List<Staff> staffCollection = new ArrayList<Staff>();
		
		for (int i = 0; i < listofleaveforms.size(); i++) {
			String staffID = listofleaveforms.get(i).getStaffid();
			Staff _staff = service.getStafffromStaffId(staffID);
			
			System.out.println(_staff.getFirstname());
			staffCollection.add(_staff);
			
		}
		
		model.addAttribute("leaveform", listofleaveforms );
		//model.addAttribute("staff", staffCollection );
	
		return "Staff/appliedleave";
	}
	
	
	@RequestMapping(value = "/viewdetail", method = RequestMethod.GET)
	public ModelAndView details(@RequestParam String staffid,
			@RequestParam String name,
			@RequestParam String createdate,
			@RequestParam String startdate,
			@RequestParam String enddate,
			@RequestParam String daystaken,
			@RequestParam String reason,
			@RequestParam String leaveformid) {
		
		ModelAndView mymodel = new ModelAndView("/Staff/viewdetail");
		mymodel.addObject("staffid", staffid);
		mymodel.addObject("name", name);
		mymodel.addObject("createdate", createdate);
		mymodel.addObject("startdate", startdate);
		mymodel.addObject("enddate", enddate);
		mymodel.addObject("daystaken", daystaken);
		mymodel.addObject("reason", reason);
		mymodel.addObject("leaveformid", leaveformid);
		
		
		
		//model.addAttribute("leaveform", listofleaveforms );
		//model.addAttribute("staff", staffCollection );
	
		return mymodel;
	}
	
	@RequestMapping(value = "/approveorreject", method = RequestMethod.POST)
	public ModelAndView approveorreject(@RequestParam String Approved,
			@RequestParam String Rejected
			,@RequestParam String leaveformid) {
		int tempid = Integer.parseInt(leaveformid);
		
		logger.info(" "+ Approved + Rejected + tempid  );
		
		if(Approved.equals("Approve")){
			
			service.updateLeaveForm(tempid, "Approved");
		}
		else
		{
			service.updateLeaveForm(tempid, "Rejected");
		}
		
		ModelAndView mymodel = new ModelAndView("redirect:/leave/leave");
		//mymodel.addObject("staffid", staffid);
		//mymodel.addObject("name", name);
		
		
		
		
		//model.addAttribute("leaveform", listofleaveforms );
		//model.addAttribute("staff", staffCollection );
	
		return mymodel;

}
//	@RequestMapping(value = "/appliedleave", method = RequestMethod.GET)
//	public String apply() {
//		return "appliedleave";
//	}
	}
