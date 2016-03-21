
package com.project.ca;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ca.exception.LeaveFormNotFound;
import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;
import com.project.ca.repository.LeaveFormRepository;
import com.project.ca.service.ViewHistoryService;



@Controller
public class ViewHistoryController {
	
	  @Autowired
	   private ViewHistoryService vhs;
	
	private static final Logger logger = LoggerFactory.getLogger(ViewHistoryController.class);
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView ViewLeaveForm()
	{
		
		List<LeaveForm> LeaveList = vhs.findAll();
		ModelAndView mav = new ModelAndView("history");
		mav.addObject("AllLeave", LeaveList);
		
		
		return mav;
	}
	@RequestMapping(value = "/history/edit/{leaveformid}", method = RequestMethod.GET)
	public ModelAndView editHistoryPage(@PathVariable int leaveformid) {	
		
		LeaveForm history= this.vhs.findRecordbyid(leaveformid);
		LeaveType typename = this.vhs.findLeaveTypeById(history.getLeaveid());
		Staff staffInfo = this.vhs.findStaffInfoById(history.getStaffid());
		
		ModelAndView mav = new ModelAndView("ViewDetails", "history",history);
		mav.addObject("leavetypename", typename);
		mav.addObject("staffInfo", staffInfo);
		return mav;
	}

	 @RequestMapping(value="/history/update/{leaveformid}",method=RequestMethod.GET)
		public String update(@PathVariable int leaveformid,Model model){
			
			LeaveForm update=vhs.findRecordbyid(leaveformid);
			model.addAttribute("update",update);
			return "updateleaveform";
		}

		 
		 @RequestMapping(value="/history/update/{leaveformid}", method=RequestMethod.POST)
			public ModelAndView updateForm(@ModelAttribute("history") LeaveForm leaveform,@RequestParam("leaveid") int leavetype,@RequestParam("address") String contact,
				/*	@RequestParam("canceled") String cancel,*/
					BindingResult result,@PathVariable int leaveformid,
					 final RedirectAttributes redirect){
		 	
			 ModelAndView mav=new ModelAndView("redirect:/history");
			try{
			 
		 	LeaveForm lf = vhs.delete(leaveform.getLeaveformid());

			 /*if(cancel!=null)
			 {vhs.cancelLeave(leaveform,cancel);}
			 	System.out.println(cancel);*/
		 	vhs.create(leaveform);
			vhs.updateContact(leaveform, contact);
			vhs.updateLeaveid(leaveform, leavetype);
			
			}
			catch(Exception e){}
			return mav;
		}
		 
		 
}
	 

