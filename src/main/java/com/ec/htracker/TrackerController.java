package com.ec.htracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import com.ec.htracker.model.Food;
import com.ec.htracker.model.User;
import com.ec.htracker.model.UserInfo;
import com.ec.htracker.services.UserLoginService;

@Controller
public class TrackerController {
	private final UserLoginService userLoginService;

	@Autowired
	public TrackerController(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	@RequestMapping("/home")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "Edip") String name) {

		String surname = "Çilli";
		String userName = "";

		model.addAttribute("user", new User());

		model.addAttribute("name", name);
		model.addAttribute("surname", surname);
		return "home";
	}

	@RequestMapping("/getFoodInfo")
	public String getFoodInfo(@Valid @ModelAttribute("user") User user, Model model)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		String recv;
		String recvbuff = "";
		URL jsonpage = new URL("http://api.nal.usda.gov/ndb/search/?format=json&q=butter&sort=n&max=25&offset=0&api_key=69teADOYfhuCeDxEnkRA75NIJUWz2Lor4NAS5R8Q");
		
		URLConnection urlcon = jsonpage.openConnection();
		BufferedReader buffread = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

		while ((recv = buffread.readLine()) != null)
			recvbuff += recv;
		buffread.close();
		
		String retVal = recvbuff;
		model.addAttribute("retval", retVal);

		return "getFoodInfo";
	}

	@RequestMapping("/loginsuccess")
	public String doLogin(@Valid @ModelAttribute("user") User user, Model model)
			throws MalformedURLException, ParserConfigurationException, SAXException, IOException {

		user = userLoginService.authenticateEncriptedUserData(user.getUserName(), user.getPassword());

		if (user != null && user.getId() > 0) {
			model.addAttribute("user", user);

			UserInfo userinf = new UserInfo();
			userinf = userLoginService.getUserInfo(user);
			model.addAttribute("userinfo", userinf);

			return "main";
		} else {
			return "home";
		}

	}

	@RequestMapping("/gotoSignUpPage")
	public String gotoSignUpPageAction(@Valid @ModelAttribute("user") User user, Model model) {
		System.out.println("SİGNUPA GİDİYEM");
		model.addAttribute("user", new User());

		return "signup";
	}

	@RequestMapping("/SignUpSuccess")
	public String doSignUp(@Valid @ModelAttribute("user") User user, Model model) {

		System.out.println(user.getUserName());
		user = userLoginService.signUp(user);

		model.addAttribute("user", user);

		UserInfo userinf = new UserInfo();
		userinf = userLoginService.getUserInfo(user);
		System.out.println("userinfo donuyem... tarckercntrller");
		System.out.println(userinf.getUserid());
		System.out.println(userinf.getCalcday());
		System.out.println(userinf.getRemainingcl());
		model.addAttribute("userinfo", userinf);

		return "main";
	}

	@RequestMapping("/gotoAddFoodPage")
	public String gotoAddFoodPage(@Valid @ModelAttribute("food") Food food, Model model) {
		System.out.println("ADD FOOD'a gidiyorum:");
		model.addAttribute("food", new Food());

		return "addfood";
	}

	@RequestMapping("/gotoMainPage")
	public String gotoMainPage(@Valid @ModelAttribute("user") User user, Model model) {
		return "main";
	}

	@RequestMapping("/gotoHistoryPage")
	public String gotoHistoryPage(@Valid @ModelAttribute("user") User user, Model model) {
		return "history";
	}

	@RequestMapping("/gotoProgressPage")
	public String gotoProgressPage(@Valid @ModelAttribute("user") User user, Model model) {
		return "progress";
	}

	@RequestMapping("/gotoProfilePage")
	public String gotoProfilePage(@Valid @ModelAttribute("user") User user, Model model) {
		return "profile";
	}

	@RequestMapping("/logout")
	public String logout(@Valid @ModelAttribute("user") User user, Model model) {
		user = null;
		return "home";
	}

}