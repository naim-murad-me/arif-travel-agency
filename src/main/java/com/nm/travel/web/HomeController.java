package com.nm.travel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nm.travel.model.Status;
import com.nm.travel.service.SecurityService;
import com.nm.travel.service.StatusService;

@Controller
@RequestMapping("/welcome")
public class HomeController {
	@Autowired private SecurityService securityService;
	@Autowired private StatusService statusService;

	@GetMapping({"/home" })
	public String welcome(Model model) {
		model.addAttribute("publicstatus", statusService.findAllList());
		return "home";
	}
	
	@GetMapping("/status")
    public String registration(Model model) {
		model.addAttribute("statusForm", new Status());
        if (securityService.isAuthenticated()) {
            return "status";
        }
        return "redirect:/login";
    }

    @PostMapping("/status")
    public String registration(@ModelAttribute("statusForm") Status statusForm, BindingResult bindingResult) {
    	statusService.save(statusForm);
        return "redirect:/welcome/home";
    }
}
