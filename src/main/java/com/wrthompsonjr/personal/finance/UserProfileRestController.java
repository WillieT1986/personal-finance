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