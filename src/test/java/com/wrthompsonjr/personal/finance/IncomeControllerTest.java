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

public class IncomeControllerTest {
	@InjectMocks
	IncomeController underTest;

	@Mock
	private IncomeRepository incomeRepo;

	@Mock
	private Income income1;

	@Mock
	Model model;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void shouldAddAnIndividualIncome() {
		long incomeId = 1L;
		when(incomeRepo.getById(incomeId)).thenReturn(income1);
		underTest.findOneIncome(incomeId, model);
		verify(model).addAttribute("income", income1);
	}


	@Test
	public void shouldReturnAnIndividualIncome() {
		String template = underTest.findOneIncome(1L, model);
		assertThat(template, is("income"));
	}
}
