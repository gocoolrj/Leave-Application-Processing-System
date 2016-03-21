package com.project.ca;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import com.project.ca.model.LeaveForm;
import com.project.ca.model.LeaveType;
import com.project.ca.model.Staff;
import com.project.ca.service.ManageLeaveService;

@Controller
@RequestMapping(value = "/manage")
public class ManageLeaveController {

	@Autowired
	private ManageLeaveService manlevrce;

	private static final Logger logger = LoggerFactory
			.getLogger(ManageLeaveController.class);

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView findAll(Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("Staff/manage_leave");
		List<LeaveForm> records = manlevrce.findbystaffid(request.getSession()
				.getAttribute("name").toString());// "s002"--staffid which
													// should be passed in while
													// staff logging in
		mav.addObject("leaveRecords", records);
		return mav;
	}

	@RequestMapping(value = "/delete/{leaveformid}", method = RequestMethod.GET)
	public String test(@PathVariable Integer leaveformid, Model model) {
		manlevrce.delete(leaveformid);
		String message = "The Record has been removed successfully";
		model.addAttribute("message", message);

		return "Staff/confirm_delet";
	}

	@RequestMapping(value = "/update/{leaveformid}", method = RequestMethod.GET)
	public String update(@PathVariable Integer leaveformid, Model model) {
		LeaveForm updtLeave = manlevrce.findRecordbyid(leaveformid);
		LeaveType leaveType = manlevrce.findbyleaveid(updtLeave.getLeaveid());
		Staff staff = manlevrce.findstaffbyid(updtLeave.getStaffid());
		model.addAttribute("staff", staff);
		model.addAttribute("update", updtLeave);
		model.addAttribute("leavename", leaveType);
		return "Staff/update_leave";
	}

	@RequestMapping(value = "/update/{leaveformid}", method = RequestMethod.POST)
	public ModelAndView updateRecord(
			@ModelAttribute("update") LeaveForm update,
			@RequestParam("leaveid") int leavetype,
			@RequestParam("address") String contact, BindingResult results,
			@RequestParam("cancelled") String cancel,
			@PathVariable int leaveformid, final Model model) {
		ModelAndView mav = new ModelAndView("Staff/confirm_updat");
		String message = "Updated successfully!";
		System.out.print(update.toString());
		manlevrce.update(update);
		manlevrce.updateLeaveid(update, leavetype);
		manlevrce.updateContact(update, contact);
		if(cancel!=null){
			manlevrce.cancelLeave(update,cancel);
		}
		model.addAttribute("message", message);
		return mav;
	}

}
