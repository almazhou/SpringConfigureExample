package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("wizardForms")
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

    @RequestMapping(value = "/testWizardForm", method = RequestMethod.GET)
    public String testWizardForm(Model model){
        WizardForm wizardForm = new WizardForm();
        model.addAttribute("wizardForms",wizardForm);
        return "wizardForm";
    }
    @RequestMapping(value = "/submitFirstForm", method = RequestMethod.POST)
    public String submitFirstForm(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("wizardForms") WizardForm wizardForm,@RequestParam("_page") int currentPage, Model model){
        Map<Integer, String> pageForm = new HashMap<Integer, String>();
        pageForm.put(0,"wizardForm");
        pageForm.put(1,"accountForm");
        pageForm.put(2,"ageForm");
        if(request.getParameter("_cancel")!= null){
            return pageForm.get(currentPage);
        }else if(request.getParameter("_finish")!= null){
            return "formSuccess";
        } else {
            int targetPage = WebUtils.getTargetPage(request,"_target",currentPage);
            if(targetPage < currentPage){
                return pageForm.get(targetPage);
            }
            return pageForm.get(targetPage);
        }
    }




}
