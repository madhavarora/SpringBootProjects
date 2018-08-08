package com.madhav.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.madhav.form.PersonForm;

@Controller
public class WebController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/results").setViewName("results");
	}
	
	@GetMapping("/")
	public String showForm(PersonForm form){
		
		return "form";
	}
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()){
			
			return "form";
		}
		return "redirect:/results";
	}
	

	
}
