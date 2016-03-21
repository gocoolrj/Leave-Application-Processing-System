package com.project.ca;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;






import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ca.model.LeaveType;
import com.project.ca.service.LeaveTypeService;

@Controller
@RequestMapping(value="/leaveType")
public class LeaveTypeController {

	@Autowired
	private LeaveTypeService ltService;
	
	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView LeaveTypeListPage(){
		ModelAndView mav = new ModelAndView("leaveType_list");
		List<LeaveType> ltList = ltService.findAll();
		mav.addObject("leaveTypeList",ltList);
		return mav; 
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newLeaveTypePage(){
		ModelAndView mav = new ModelAndView("leaveType_new","leaveType",new LeaveType());
		return mav; 
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewLeaveType(@ModelAttribute("leaveType") LeaveType lt,BindingResult result,final RedirectAttributes redirectAttributes){
		
		if(result.hasErrors())
			return new ModelAndView("leaveType_new");
				
		ModelAndView mav = new ModelAndView();
		String message = "New Leave Type \"" + lt.getLeavetype() + "\" was successfully created.";
		ltService.create(lt);
		mav.setViewName("redirect:/leaveType/list.html");
		redirectAttributes.addFlashAttribute("message",message);
		return mav; 
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editLeaveTypePage(@PathVariable int id){
		ModelAndView mav = new ModelAndView("leaveType_update");
		LeaveType lt = ltService.findById(id);
		mav.addObject("leaveType",lt);
		return mav; 
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editLeaveType(@ModelAttribute("leaveType") LeaveType lt,BindingResult result,@PathVariable int id,final RedirectAttributes redirectAttributes){
		
		if(result.hasErrors())
			return new ModelAndView("leaveType_update");
				
		ModelAndView mav = new ModelAndView("redirect:/leaveType/list.html");
		String message = "Leave Type was successfully updated.";
		ltService.update(lt); 
		redirectAttributes.addFlashAttribute("message",message);
		return mav; 
	}
	
	@RequestMapping(value="/delete/{id}" , method = RequestMethod.GET)
	public ModelAndView deleteLeaveType(@PathVariable int id,final RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("redirect:/leaveType/list.html");
		//System.out.println(id);
		LeaveType lt = ltService.delete(id);
		String message = "The Leave Type \""+ lt.getLeavetype() +"\" was successfully deleted.";
		redirectAttributes.addFlashAttribute("message",message);
		return mav;		
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String newindextest() {

		return "Admin";
	}
	
	
}
