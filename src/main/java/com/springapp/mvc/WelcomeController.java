package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome" ,method = RequestMethod.GET)
    public String welcome(Model model){
        Date today = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addAttribute("today","zhouxuan<script>alert(\"hello world\")</script>");
        return "welcome";
    }

    @RequestMapping(value = "/submitThis" ,method = RequestMethod.POST)
    public String submit(@RequestParam String fname,@RequestParam String lname,HttpServletRequest request){
        request.setAttribute("firstName",fname);
        request.setAttribute("lastName",lname);
        return "welcome";
    }



}
