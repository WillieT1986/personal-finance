package com.wrthompsonjr.personal.finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserProfileRestController {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(UserProfileRestController.class);

	@Resource
	UserProfileRepository userProfileRepo;

	@Resource
	BillRepository billRepo;

	@Resource
	IncomeRepository incomeRepo;


//	User Profile
	public String findUserProfiles(Model model) {
		model.addAttribute("userProfiles", userProfileRepo.findAll());
		return "userProfiles";
	}

	@RequestMapping("/userProfiles/{id}")
	public UserProfile findUserProfile(@PathVariable(name = "id") Long id) {
		if (userProfileRepo.getById(id) == null){
			throw new CannotFindException("User Profile Does Not Exist...");
		}
		return userProfileRepo.getById(id);
	}

	@RequestMapping("/userProfile/bill/{id}")
	public Iterable<Bill> findBillsByUserProfileId(@PathVariable(name = "id") Long id) {
		return userProfileRepo.getById(id).getBills();
	}

	@RequestMapping("userProfile/income/{id}")
	public Iterable<Income> findIncomesByUserProfileId(@PathVariable(name = "id") Long id ) {
		return userProfileRepo.getById(id).getIncomes();
	}


//	Bill
	public String findBills(Model model) {
		model.addAttribute("bills", billRepo.findAll());
		return "bills";
	}

	public Iterable<Bill> findBillsByUserProfile(String userProfile) {
		return userProfileRepo.findOneByUserProfile(userProfile).getBills();
	}

	@RequestMapping("/bills/{id}")
	public Bill findBill(@PathVariable(name = "id") Long id) {
		if (billRepo.getById(id) == null) {
			throw new CannotFindException("This Bill Does Not Exist.");
		}
		return billRepo.getById(id);
	}


// Income
	public String findIncomes(Model model) {
		return "incomes";
	}

	public Iterable<Income> findIncomesByUserProfile(String userProfile) {
		return userProfileRepo.findOneByUserProfile(userProfile).getIncomes();
	}

	@RequestMapping("/incomes/{id}")
	public Income findIncome(@PathVariable(name = "id") Long id) {
		if (incomeRepo.getById(id) == null) {
			throw new CannotFindException("This Income Does Not Exist...");
		}
		return incomeRepo.getById(id);
	}

	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class CannotFindException extends RuntimeException {
		private String message;

		public String getMessage() {
			return message;
		}

		CannotFindException(String errorMessage) {
			this.message = errorMessage;
		}
	}
}