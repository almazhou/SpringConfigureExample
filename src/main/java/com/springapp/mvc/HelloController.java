package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(value = "/testView",method = RequestMethod.GET)
	public ModelAndView testMyView() {
		return new ModelAndView("myView");
	}

    @RequestMapping(value = "/testRedirect",method = RequestMethod.GET)
    public ModelAndView welcomeRedirect() {
        return new ModelAndView("welcomeRedirect");
    }

    @RequestMapping(value = "/testPropertyView",method = RequestMethod.GET)
    public ModelAndView propertyView() {
        return new ModelAndView("propertyView");
    }


}