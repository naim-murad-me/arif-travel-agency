package com.nm.travel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nm.travel.model.User;
import com.nm.travel.service.SecurityService;
import com.nm.travel.service.StatusService;
import com.nm.travel.service.UserService;

@Controller
public class UserController {
	@Autowired private UserService userService;
	@Autowired private SecurityService securityService;
	@Autowired private UserValidator userValidator;
	@Autowired private StatusService statusService;

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
        	return "redirect:/welcome/home";
        }

        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/welcome/home";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
   
    @GetMapping({"/" })
	public String welcome(Model model) {
		model.addAttribute("publicstatus", statusService.findAllList());
		return "home";
	}
}
