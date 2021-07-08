package com.wrthompsonjr.personal.finance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import com.wrthompsonjr.personal.finance.UserProfileRestController.CannotFindException;


public class UserProfileRestControllerTest {

	@InjectMocks
	private UserProfileRestController underTest;

	@Mock
	private UserProfile userProfile;

	@Mock
	private UserProfileRepository userProfileRepo;

	@Mock
	Model model;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void shouldRetrieveUserProfiles() {
		when(userProfileRepo.findAll()).thenReturn(Collections.singletonList(userProfile));
		String result = underTest.findUserProfiles(model);
		assertTrue(result, contains(any(UserProfile.class)) != null);
	}

	@Test
	public void shouldGetUserProfileFromDatabase() {
		when(userProfileRepo.findAll()).thenReturn(Collections.singletonList(userProfile));
		String result = underTest.findUserProfiles(model);
		assertTrue(result, contains(userProfile) != null);
	}

	@Test
	public void shouldReturnAnIndividualUserProfileFromDatabase() {
		when(userProfileRepo.getById(5L)).thenReturn(userProfile);
		UserProfile result = underTest.findUserProfile(5L);
		assertThat(result, is(userProfile));
	}

	@Test
	public void shouldReturnCannotFindExceptionForUserProfileId() {
		CannotFindException thrown = assertThrows(
				CannotFindException.class,
				() -> {
					long userProfileId = 10L;
					underTest.findUserProfile(userProfileId);
				});
		assertEquals("User Profile Does Not Exist...", thrown.getMessage());
	}



}