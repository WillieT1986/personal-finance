package com.wrthompsonjr.personal.finance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class IncomeController {

	@Resource
	private IncomeRepository incomeRepo;

	@RequestMapping("income")
	public String findOneIncome(@RequestParam Long id, Model model) {
		model.addAttribute("income", incomeRepo.getById(id));
		return "income";
	}

}