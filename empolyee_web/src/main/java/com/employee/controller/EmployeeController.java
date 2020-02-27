package com.employee.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	Logger logger = Logger.getLogger(EmployeeController.class.getName());
	
	
	
	@PostMapping("/save")
	public String saveNewEmployee(@ModelAttribute("employee") Employee theEmployee) {
		logger.info("New Employee Entry from page-->" + theEmployee);
		
		
		employeeService.saveEmployee(theEmployee);
		
//		Redirect to homepage
		return "redirect:/";
	}
	
	@GetMapping("/add")
	public String addEmployee( Model employeeModel) {
		
//		 Create an instance of an entity
		Employee employee = new Employee();
		
		employeeModel.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		
		List<Employee> allSavedEmployees = employeeService.findAll();
		
		model.addAttribute("employeeList", allSavedEmployees);
		
		return "home";
		
	}
	
	@GetMapping("/updateform")
	public ModelAndView updateEmployee(@RequestParam("employeeId") int employeeId) {
		
		logger.info("New update request-->"  + employeeId);
		
		Employee existingEmployee = employeeService.getById(employeeId);
		
		logger.info("Initial employee details->>" + existingEmployee);
		
		return  new ModelAndView("update-form", "employee", existingEmployee);
	}

	
}
