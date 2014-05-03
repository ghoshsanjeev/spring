package com.bt.nat.esitest;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bt.nat.account.AccountRepository;
import com.bt.nat.account.TEsitestWebGatekeeperUsers;
import com.bt.nat.building.BuildingsRepository;
import com.bt.nat.engineer.EngineerRepository;

@Controller
public class EsitestController {

	private static final String ITEM_VIEW_NAME = "home/homeSignedIn";

	@Autowired
	private EsitestRepository esiTestRepository;

	@Autowired
	private EngineerRepository engineerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BuildingsRepository buildingsRepository;

	@RequestMapping(value = "dueEsitest", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String itemSearch(ModelMap model, HttpSession session) {

		TEsitestWebGatekeeperUsers account = (TEsitestWebGatekeeperUsers) session
				.getAttribute("currentUser");

		Integer item = account.getWguEin();

		List esiTests = esiTestRepository.findByEinDue(new Integer(item));
		
		model.addAttribute("dueesitest", esiTests);
		
		List overDueEsiTests = esiTestRepository.findByEinOverDue(new Integer(item));
		
		model.addAttribute("overDueEsiTests", overDueEsiTests);
		
		Object[] oarr = (Object[])overDueEsiTests.get(0);
	
		System.out.println("after itemSearch in dueEsitest -- > " + esiTests);
		return ITEM_VIEW_NAME;
	}

}
