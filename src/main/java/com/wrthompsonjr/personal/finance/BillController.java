package com.wrthompsonjr.personal.finance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class BillController {

	@Resource
	private BillRepository billRepo;

	@RequestMapping("bill")
	public String findOneBill(@RequestParam Long id, Model model) {
		model.addAttribute("bill", billRepo.getById(id));
		return "bill";
	}

}