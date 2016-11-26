package com.ec.htracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrackerController {
    @RequestMapping("/home")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="Edip") String name) {
            	
    	String surname = "Çilli";
    	String userName = "";
    	
    	model.addAttribute("name", name);
    	model.addAttribute("surname", surname);
        return "home";
    }
}