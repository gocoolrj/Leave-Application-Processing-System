package com.project.ca;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ca.model.Holiday;
import com.project.ca.model.Staff;
import com.project.ca.service.HolidayService;

@Controller
@RequestMapping(value= "/holiday")
public class HolidayController {
	
	@Autowired
	private HolidayService holidayService;
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView staffListPage(){
		ModelAndView mav = new ModelAndView("holiday_list");
		List<Holiday> allHoliday = holidayService.findAll();
		mav.addObject("allHoliday",allHoliday);
		System.out.println(allHoliday.get(0));
		return mav;
	}
	
	//link to add page
		@RequestMapping(value = "/create", method = RequestMethod.GET)
		public ModelAndView newHolidayPage() {
			ModelAndView mav = new ModelAndView("holiday_new", "holiday",new Holiday());
			return mav;
		}
		
		//link to after add 
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		public ModelAndView createNewHoliday(@ModelAttribute ("holiday") Holiday holiday,
				BindingResult result, final RedirectAttributes redirectAttributes) throws ParseException {
			
			/*System.out.println(holiday.getHdate());*/
			
			/*if (result.hasErrors())
				return new ModelAndView("addHoliday");*/
		
			/*String startDate=holiday.getHdate().toString();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date = sdf1.parse(startDate);
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			holiday.setHdate(sqlStartDate);*/
			
			
			System.out.println("Testing add holiday"+holiday.getHdate());
			String startDate=holiday.getHdate().toString();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date = sdf1.parse(startDate);
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			holiday.setHdate(sqlStartDate);
			
			
			
			ModelAndView mav = new ModelAndView();
			String message = "New Holiday " + holiday.getHdate()
					+ " was successfully created.";
			
			holidayService.create(holiday);
			mav.setViewName("redirect:/holiday/list");

			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		@RequestMapping(value = "/admin", method = RequestMethod.GET)
		public String newindextest() {

			return "Admin";
		}
}
