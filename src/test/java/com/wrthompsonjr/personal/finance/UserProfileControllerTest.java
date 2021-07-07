package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserProfileControllerTest {

	@InjectMocks
	UserProfileController underTest;

	@Mock
	private UserProfileRepository userProfileRepo;

	@Mock
	private UserProfile userProfile1;

	@Mock
	Model model;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void shouldAddAnIndividualUserProfile() {
		long userProfileId = 1L;
		when(userProfileRepo.getById(userProfileId)).thenReturn(userProfile1);
		underTest.findOneUserProfile(userProfileId, model);
		verify(model).addAttribute("userProfile", userProfile1);
	}


	@Test
	public void shouldReturnAnIndividualUserProfile() {
		String template = underTest.findOneUserProfile(1L, model);
		assertThat(template, is("userProfile"));
	}
}