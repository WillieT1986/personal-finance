package com.wrthompsonjr.personal.finance;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class UserProfileController {

	@Resource
	private UserProfileRepository userProfileRepo;

	@RequestMapping("userProfile")
	public String findOneUserProfile(@RequestParam Long id, Model model) {
		model.addAttribute("userProfile", userProfileRepo.getById(id));
		return "userProfile";
	}

}