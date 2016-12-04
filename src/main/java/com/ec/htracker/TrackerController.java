package com.ec.htracker;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import com.ec.htracker.Model.User;
import com.ec.htracker.services.UserLoginService;

@Controller
public class TrackerController {
	private final UserLoginService userLoginService;
	
	@Autowired
    public TrackerController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }
	
    @RequestMapping("/home")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="Edip") String name) {
            	
    	String surname = "Çilli";
    	String userName = "";
    	
    	model.addAttribute("user", new User());
    	
    	model.addAttribute("name", name);
    	model.addAttribute("surname", surname);
        return "home";
    }
    
    @RequestMapping("/loginsuccess")
	public String doLogin(@Valid @ModelAttribute("user")User user, Model model ) throws MalformedURLException, ParserConfigurationException, SAXException, IOException {    	
    	   	
    	if(!userLoginService.authenticateEncriptedUserData(user.getUserName(), user.getPassword())){
    		return "home";
    	}

    	
		return "index";
	}    
//    @RequestMapping("/signup")
//    public String signUp(Model model, @RequestParam(value="name", required=false, defaultValue="Edip") String name) {
//            	
//    	//Create user account 
//    	String surname = "Selin Cilli";
//    	model.addAttribute("name", name);
//    	model.addAttribute("surname", surname);
//    	// Get user information
//        return "home";
//    }
}