package com.project.ca;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ca.exception.StaffNotFoundException;
import com.project.ca.model.LeaveForm;
import com.project.ca.model.Staff;
import com.project.ca.service.ManageLeaveService;
import com.project.ca.service.ManageStaffService;
//import com.project.ca.validator.StaffValidator;



@Controller
@RequestMapping(value= "/staff")
public class ManageStaffController {
	
	@Autowired
	private ManageStaffService staffService;
	
	@Autowired
	private ManageLeaveService lfService;
	

	
	private static final Logger logger = LoggerFactory.getLogger(ManageStaffController.class);
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView staffListPage(){
		ModelAndView mav = new ModelAndView("staff_list");
		List<Staff> allstaff = staffService.findAll();
		mav.addObject("allstaff",allstaff);
		System.out.println(allstaff.get(0));
		return mav;
		
	}
	
	//link to add page
		@RequestMapping(value = "/create", method = RequestMethod.GET)
		public ModelAndView newStaffPage() {
			ModelAndView mav = new ModelAndView("staff_new", "staff",
					new Staff());
			return mav;
		}

		//link to after add 
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		public ModelAndView createNewStaff(@ModelAttribute ("staff") Staff staff,
				BindingResult result, final RedirectAttributes redirectAttributes) {

			
			if (result.hasErrors())
				return new ModelAndView("staff_new");
			
			System.out.println(staff);
			
			ModelAndView mav = new ModelAndView();
			String message = "New Staff " + staff.getFirstname()
					+ " was successfully created.";

			staffService.create(staff);
			mav.setViewName("redirect:/staff/list.html");

			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		
	//link to update page
	@RequestMapping(value = "/update", method = RequestMethod.GET )
	public ModelAndView fdfdsfs(@RequestParam String staffid) {
		logger.info("Testing "+staffid);
		Staff staff = this.staffService.findById(staffid);
		ModelAndView mav = new ModelAndView("staff_update","staff",staff);
		return mav;
	}


	//link to after update
	@RequestMapping(value = "/update/{staffid}", method = RequestMethod.POST)
	public ModelAndView updateStaff(@ModelAttribute("staff") @Valid Staff staff,
			BindingResult result, @PathVariable String staffid,
			final RedirectAttributes redirectAttributes) throws StaffNotFoundException {
		if (result.hasErrors())
			return new ModelAndView("/update");
		
		ModelAndView mav = new ModelAndView("redirect:/staff/list.html");
		System.out.println(staff.getStaffid());
		System.out.println(staff.getLastname());
		staffService.update(staff);
		return mav;
	}

	

	//link to delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET )
	public ModelAndView deleteStaff(@RequestParam String staffid,final RedirectAttributes redirectAttributes) throws StaffNotFoundException {
		logger.info("Staff ID  "+staffid);
			/*System.out.println("Staff ID : " + staffid);
			List<LeaveForm> lfList = lfService.fin
			System.out.println("Leave form List : " + lfList);*/
			ModelAndView mav = new ModelAndView("redirect:/staff/list.html");
			Staff staff = staffService.delete(staffid);
			String message = "The Staff " + staff.getStaffid() + " was successfully deleted.";
			redirectAttributes.addFlashAttribute("message",message);					
			return mav;
		}
	//link to manage hierarchy
	@RequestMapping(value ="/hierarchy/list", method = RequestMethod.GET)
	public ModelAndView ManageHierarchy(){
		ModelAndView mav = new ModelAndView("hierarchy_list");
		List<Staff> allstaff = staffService.findAll();
		mav.addObject("allstaff",allstaff);
		System.out.println(allstaff.get(0));
		return mav;
	}
	
	//link to update hierarchy
	@RequestMapping(value = "/hierarchy/edit", method = RequestMethod.GET )
	public ModelAndView Hierarchy(@RequestParam String staffid) {
		logger.info("Testing "+staffid);
		Staff staff = this.staffService.findById(staffid);
		ModelAndView mav = new ModelAndView("hierarchy_update","staff",staff);
		return mav;
	}
	//link to after update hierarchy
	@RequestMapping(value = "/hierarchy/edit/{staffid}", method = RequestMethod.POST)
	public ModelAndView afterUpdateH(@ModelAttribute("staff") @Valid Staff staff,
			BindingResult result, @PathVariable String staffid,
			final RedirectAttributes redirectAttributes) throws StaffNotFoundException {
		if (result.hasErrors())
			return new ModelAndView("/staff/hierarchy/edit");
		
		ModelAndView mav = new ModelAndView("redirect:/staff/hierarchy/list");
		System.out.println(staff.getStaffid());
		System.out.println(staff.getLastname());
		staffService.update(staff);
		return mav;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String newindextest() {

		return "Admin";
	}
	

}
