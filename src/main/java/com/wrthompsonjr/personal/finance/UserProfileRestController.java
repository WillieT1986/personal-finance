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

	@RequestMapping("/userProfile/{id}")
	public Iterable<Bill> findBillsByUserProfileId(@PathVariable(name = "id") Long id) {
		return userProfileRepo.getById(id).getBills();
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