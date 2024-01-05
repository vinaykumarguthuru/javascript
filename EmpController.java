package com.emp.sys.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.emp.sys.entity.Employee;
import com.emp.sys.service.EmpService;



@Controller
public class EmpController {

	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(Model m) {

		System.out.println("Inside home");
		List<Employee> emp = service.getEmps();
		System.out.println("employees" + emp);
		m.addAttribute("emp", emp);
		return "index";

	}

	@GetMapping("addemp")
	public String addemp() {
		return "add_emp";
	}
	
	

	@PostMapping("register")
	public String register(@ModelAttribute Employee e) {
		System.out.println(e);
		service.addemp(e);
		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEmpid(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e) {
		  service.addemp(e);
		  return "redirect:/";
		
	}
	
	 @GetMapping("/delete/{id}")
     public String deleteEmp(@PathVariable int id) {
		 
		 service.deleteEmp(id);
		   
		return "redirect:/";
    	 
    	 
     }

}
