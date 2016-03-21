package com.project.ca;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ca.model.LeaveForm;
import com.project.ca.service.CreateLeaveService;

@Controller
@RequestMapping(value="/CreateLeave")
public class CreateLeaveController {
	@Autowired
	private CreateLeaveService cls;
	
	@RequestMapping(value="/applying",method=RequestMethod.GET)
	public ModelAndView newLeaveApply()
	{
		ModelAndView mma= new ModelAndView("Staff/CreateLeave","lfs",new LeaveForm());
		return mma;
		
	}
@RequestMapping(value="/applying/Staff",method=RequestMethod.POST)
public ModelAndView  newLeaveApply(@ModelAttribute@Valid LeaveForm lfs, BindingResult result, final RedirectAttributes redirectAttributes,HttpServletRequest request)
{
	
	ModelAndView mma= new ModelAndView("redirect:/Staff/Staff");
	cls.CreateLeave(lfs);
	System.out.println(request.getRequestedSessionId());
	return mma;
	
	
}


	
@RequestMapping(value="/Staff",method=RequestMethod.GET)
public String newpaget()
{
	
	return "Staff/Staff";

}

@RequestMapping(value="/Staff",method=RequestMethod.POST)
public String newpaget(HttpServletRequest request)
{
	
	return "Staff/Staff";

}

}


