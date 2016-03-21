package com.project.ca;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ca.model.Role;
import com.project.ca.repository.RoleRepository;
import com.project.ca.service.RoleService;

@Controller
@RequestMapping(value="/role")
public class RoleController {
	
	 @Autowired
	 private RoleService rService;
	 
	 private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	 
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView roleListPage(){
			ModelAndView mav = new ModelAndView("role_list");
			List<Role> roleList = rService.findAll();
			mav.addObject("roleList",roleList);
			return mav; 
		}
		
		@RequestMapping(value="/create", method = RequestMethod.GET)
		public ModelAndView newRolePage(){
			ModelAndView mav = new ModelAndView("role_new","role",new Role());
			return mav;
		}
		
		@RequestMapping(value="/create", method = RequestMethod.POST)
		public ModelAndView createNewRole(@ModelAttribute("role") Role role, BindingResult result,final RedirectAttributes redirectAttributes){
			
			if(result.hasErrors())
				return new ModelAndView("role_new");
			ModelAndView mav = new ModelAndView();
			String message = "New role \"" + role.getTitle() + "\" was successfully created."; 
			rService.create(role);
			mav.setViewName("redirect:/role/list.html");
			redirectAttributes.addFlashAttribute("message",message);
			return mav;
		}
		
		@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
		public ModelAndView editRolePage(@PathVariable int id){
			ModelAndView mav = new ModelAndView("role_update");
			Role r = rService.findById(id);
			mav.addObject("role",r);
			return mav;
		}
		
		@RequestMapping(value="/edit/{id}",method=RequestMethod.POST)
		public ModelAndView editRole(@ModelAttribute("role") Role role,BindingResult result, @PathVariable int id,final RedirectAttributes redirectbutes){
			if(result.hasErrors())
				return new ModelAndView("role_update");
			
			ModelAndView mav = new ModelAndView("redirect:/role/list.html");
			String message = "Role was successfully updated.";
			rService.update(role);
			
			redirectbutes.addFlashAttribute("message",message);
			return mav;
		}
		
		//can't delete role coz of foreign key constraint
		
		@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
		public ModelAndView deleteRole(@PathVariable int id,final RedirectAttributes redirectAttributes){
			
			ModelAndView mav = new ModelAndView("redirect:/role/list.html");
			Role r = rService.delete(id);
			String message = "The Role \"" + r.getTitle() + "\" was successfully deleted.";
			redirectAttributes.addFlashAttribute("message",message);					
			return mav;
		}
		
		@RequestMapping(value = "/admin", method = RequestMethod.GET)
		public String newindextest() {

			return "Admin";
		}
		
}
