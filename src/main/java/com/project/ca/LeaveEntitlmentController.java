package com.project.ca;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ca.exception.StaffNotFoundException;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;
import com.project.ca.service.LeaveTypeService;

@Controller
@RequestMapping(value= "/entitlement")
public class LeaveEntitlmentController {
	
	@Autowired
	private LeaveTypeService lTypeService;
	
	private static final Logger logger = LoggerFactory.getLogger(LeaveEntitlmentController.class);
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView AllLeavePage(){
		System.out.println("Get in LeaveList Mapping");
		ModelAndView mav = new ModelAndView("entitlement_list");
		List<LeaveType> allLeave = lTypeService.findAll();
		mav.addObject("allLeave",allLeave);
		System.out.println(allLeave.get(0));
		return mav;
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET )
	public ModelAndView updateLeaveType1(@RequestParam Integer leaveid) {
		logger.info("Testing "+leaveid);
		LeaveType leaveType = this.lTypeService.findById(leaveid);
		ModelAndView mav = new ModelAndView("entitlement_update","leaveType",leaveType);
		return mav;
	}
	
	//link to after update
		@RequestMapping(value = "/update/{leaveid}", method = RequestMethod.POST)
		public ModelAndView updateStaff(@ModelAttribute("leavetype") @Valid LeaveType leavetype,
				BindingResult result, @PathVariable Integer leaveid,
				final RedirectAttributes redirectAttributes) {
			if (result.hasErrors())
				return new ModelAndView("/update");
			
			ModelAndView mav = new ModelAndView("redirect:/entitlement/list");
			System.out.println(leavetype.getLeaveid());
			lTypeService.update(leavetype);
			return mav;
		}
		

		@RequestMapping(value = "/admin", method = RequestMethod.GET)
		public String newindextest() {

			return "Admin";
		}
		

}
