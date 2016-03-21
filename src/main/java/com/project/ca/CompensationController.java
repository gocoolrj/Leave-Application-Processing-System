package com.project.ca;


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
import com.project.ca.service.CompensationService;

@Controller
@RequestMapping(value="/leaveform")
public class CompensationController {
		 
	   
		@Autowired
		private CompensationService comcl;
		
		@RequestMapping(value="/apply-form",method=RequestMethod.GET)
		public ModelAndView newCompensationapply()
		{
			ModelAndView mav = new ModelAndView("Staff/leaveform","lf",new LeaveForm());
			return mav;
		}
		
		@RequestMapping(value="/apply-form",method=RequestMethod.POST)
		public ModelAndView newCompensationapply(@ModelAttribute@Valid LeaveForm lf,
				BindingResult result,final RedirectAttributes redirectAttributes)
		{
			System.out.println(lf.getComment());
			ModelAndView mav= new ModelAndView("redirect:/Staff/Staff");
			comcl.createcompensation(lf);
			return mav;
		}
		
		
}

/*
package com.project.ca;


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
import com.project.ca.service.CompensationService;

@Controller
@RequestMapping(value="/leaveform")
public class CompensationController {
		 
	   
		@Autowired
		private CompensationService comcl;
		
		@RequestMapping(value="/apply-form",method=RequestMethod.GET)
		public ModelAndView newCompensationapply()
		{
			ModelAndView mav = new ModelAndView("Staff/leaveform","lf",new LeaveForm());
			return mav;
		}
		
		@RequestMapping(value="/apply-form",method=RequestMethod.POST)
		public ModelAndView newCompensationapply(@ModelAttribute@Valid LeaveForm lf,
				BindingResult result,final RedirectAttributes redirectAttributes)
		{
			System.out.println(lf.getComment());
			ModelAndView mav= new ModelAndView();
			comcl.createcompensation(lf);
			return mav;
		}
		
		
}
*/
