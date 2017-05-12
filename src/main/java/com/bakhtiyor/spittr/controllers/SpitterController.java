package com.bakhtiyor.spittr.controllers;

import com.bakhtiyor.spittr.models.Spitter;
import com.bakhtiyor.spittr.repositories.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRepository;

	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET) 
	public String showRegistrationForm() {
	    return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors) {
		if (errors.hasErrors()) {
		    return "registerForm";
        }

	    spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();		
	}

	@RequestMapping(value = "/{spitter}")
	public String viewSpitter(@PathVariable("spitter") String spitterUsername, Model model) {
		model.addAttribute(spitterRepository.findOneByUsername(spitterUsername));
		return "profile";
	}
}