package com.bt.nat.home;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bt.nat.account.AccountRepository;
import com.bt.nat.account.TEsitestWebGatekeeperUsers;

@Controller
public class HomeController {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private HomeRepository homeRepository;

	public static Map<String, String[]> accestypes;

	static {
		accestypes = new HashMap<String, String[]>();
		accestypes.put("Admin", new String[] { "Admin","NA", "SM", "FM", "EN", "LT",
				"REP" });
		accestypes.put("SAdmin", new String[] { "Admin", "NA", "SM", "FM",
				"EN", "LT", "TM", "REP" });
		accestypes.put("NA", new String[] { "REP", "EN" });
		accestypes.put("SM", new String[] { "EN", "FM" });
		accestypes.put("FM", new String[] { "REP", "EN" });
		accestypes.put("EN", new String[] { "REP", "EN" });
		accestypes.put("LT", new String[] { "REP", "EN" });
		accestypes.put("TM", new String[] { "Admin", "REP", "FM", "EN" });
		accestypes.put("AM", new String[] { "AM" });

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, HttpSession session, ModelMap model) {

		if (principal != null) {
			TEsitestWebGatekeeperUsers account = accountRepository
					.findByEin(new Integer(principal.getName()));
			session.setAttribute("currentUser", account);
			model.addAttribute("mainMenu", homeRepository
					.findMainMenuButtonsByType("main_page",
							Arrays.asList(accestypes.get((account
									.getWguProfileName())))));
			return "home/homeSignedIn";
		} else {
			session.removeAttribute("currentUser");
			return "signin/signin";
		}
	}
}
