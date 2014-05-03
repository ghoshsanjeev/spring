package com.bt.nat.item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bt.nat.account.AccountRepository;
import com.bt.nat.account.TEsitestWebGatekeeperUsers;
import com.bt.nat.building.BuildingsRepository;
import com.bt.nat.engineer.EngineerRepository;
import com.bt.nat.engineer.TEsitestEngineerPostcode;

@Controller
public class ItemController {

	private static final String ITEM_VIEW_NAME = "home/homeSignedIn";

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private EngineerRepository engineerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BuildingsRepository buildingsRepository;

	@RequestMapping(value = "additem")
	public String addItem(Model model) {
		model.addAttribute(new ItemSearchForm());
		return ITEM_VIEW_NAME;
	}

	@RequestMapping(value = "itemSearch", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String itemSearch(
			@Valid @ModelAttribute ItemSearchForm itemSearchForm,
			Errors errors, ModelMap model) {
		if (errors.hasErrors()) {
			return ITEM_VIEW_NAME;
		}

		String item = itemSearchForm.getItem();
		int type = itemSearchForm.getType();
		List<TEsitestItems> items = null;

		ItemForm itemForm = new ItemForm();

		switch (type) {
		case 1:
			items = itemRepository.findByEin(new Integer(item));
			TEsitestWebGatekeeperUsers user = accountRepository
					.findByEin(new Integer(item));
			model.addAttribute("user", user);
			itemForm.setEin(new Integer(item));
			break;
		}

		model.addAttribute("items", items);
		model.addAttribute("itemMaster", itemRepository.findAllItems());
		model.addAttribute("buildingMaster",
				buildingsRepository.findAllBuildings());

		model.addAttribute(itemForm);
		System.out.println("after itemSearch");
		return ITEM_VIEW_NAME;
	}

	@RequestMapping(value = "itemUpdate", method = RequestMethod.POST)
	public @ResponseBody
	String itemUpdate(@RequestParam(value = "id") String id,
			@RequestParam(value = "value") String value,
			@RequestParam(value = "columnName") String columnName,
			@RequestParam(value = "columnId") String columnId,
			@RequestParam(value = "columnPosition") String columnPosition,
			@RequestParam(value = "rowId") String rowId) throws ParseException {

		TEsitestItems item = itemRepository.findById(new Long(id));
		System.out.println(item.getTeiNextCheckDate());

		if ("Next Check Date".equals(columnName)) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format.parse(value);
			item.setTeiNextCheckDate(date);
		}

		if ("Remarks".equals(columnName)) {
			item.setTeiRemarks(value);
		}

		if ("Item Serial".equals(columnName)) {
			item.setTeiItemSerial(value);
		}

		itemRepository.update(item);

		return value;
	}

	@RequestMapping(value = "itemDelete", method = RequestMethod.POST)
	public @ResponseBody
	String itemDelete(@RequestParam(value = "id") String id)
			throws ParseException {

		itemRepository.delete(new Long(id));

		return "ok";
	}

	@RequestMapping(value = "itemAdd", method = RequestMethod.POST)
	public String itemAdd(@Valid @ModelAttribute ItemForm itemForm,
			RedirectAttributes redirectAttributes) throws ParseException {

		TEsitestItems item = new TEsitestItems();
		item.setTeiDateOfAdd(new Date());
		item.setTeiIsBuilding(itemForm.getItemType());
		item.setTeiItemSerial(itemForm.getItemSerial());

		TEsitestItemStatus itemStatus = new TEsitestItemStatus();
		itemStatus.setTisItemStatusId(14);
		item.setItemStatus(itemStatus);

		TEsitestItemMaster master = new TEsitestItemMaster();
		master.setTimId(itemForm.getItem());
		item.setTeiMaster(master);
		item.setTeiRemarks(itemForm.getRemarks());
		item.setTeiEngineerEin(itemForm.getEin());
		item.setTeiEngineerEinOld(Integer.toString(itemForm.getEin()));

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		item.setTeiNextCheckDate(format.parse(itemForm.getNextCheckDate()));

		ItemSearchForm itemSearchForm = new ItemSearchForm();
		itemSearchForm.setItem(Integer.toString(itemForm.getEin()));
		itemSearchForm.setType(1);

		itemRepository.save(item);

		redirectAttributes.addFlashAttribute("itemSearchForm", itemSearchForm);

		return "redirect:/itemSearch";
	}

	@RequestMapping(value = "myItems", method = RequestMethod.GET)
	public String myItems(ModelMap model, HttpSession session) {

		TEsitestWebGatekeeperUsers account = (TEsitestWebGatekeeperUsers) session
				.getAttribute("currentUser");

		Integer item = account.getWguEin();
		List<TEsitestItems> items = null;

		items = itemRepository.findByEin(new Integer(item));

		TEsitestEngineerPostcode engPostCodes = engineerRepository
				.findByEin(new Integer(item));

		TEsitestWebGatekeeperUsers testerRecord = accountRepository
				.findByEin(engPostCodes.getTeePostcode().getEpoTesterEin());
		String tester = testerRecord.getWguFirstname() + " "
				+ testerRecord.getWguSurname();

		model.addAttribute("tester", tester);

		model.addAttribute("myitems", items);

		System.out.println("after itemSearch");
		return ITEM_VIEW_NAME;
	}
}
