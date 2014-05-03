package com.bt.nat.navigate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bt.nat.account.AccountRepository;
import com.bt.nat.home.HomeRepository;

@Controller
public class NavigateController {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private HomeRepository homeRepository;

	private static Map<String, String> pageTypes;

	static {
		pageTypes = new HashMap<String, String>();
		pageTypes.put("My esiTest", "my_esitest_mod");
		pageTypes.put("Manager", "mgr_mod");
		pageTypes.put("Snr. Manager", "snr_mgr_mod");
		pageTypes.put("Safety Manager", "sp_mgr_mod");
		pageTypes.put("Mobile Tester", "tester_mod");
		pageTypes.put("Scheduling", "cag_mod");
		pageTypes.put("Appointments", "appointment_mod");
		pageTypes.put("Test Manager", "test_manager");
		pageTypes.put("Super Admin", "super_user_admin_mod");
		pageTypes.put("User Master", "eight_user_master_mod");
	}

	@RequestMapping(value = "/navigate", method = RequestMethod.GET)
	public String navigate(@RequestParam(value = "name") String name,
			ModelMap model, RedirectAttributes attributes) {

		
		if("Add / Edit Items".equals(name)){
			return "redirect:/additem";
		}
		
		if("Add User".equals(name)){
			return "redirect:/signup";
		}
		
		if("My Items".equals(name)){
			return "redirect:/myItems";
		}
		
		if("Due esiTest".equals(name)){
			return "redirect:/dueEsitest";
		}
		
		model.addAttribute("subMenu",
				homeRepository.findSubMenuButtonsByType(pageTypes.get(name)));
		return "home/homeSignedIn";
	}
}
