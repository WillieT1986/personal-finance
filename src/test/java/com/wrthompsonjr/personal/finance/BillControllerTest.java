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

public class BillControllerTest {

	@InjectMocks
	BillController underTest;

	@Mock
	private BillRepository billRepo;

	@Mock
	private Bill bill1;

	@Mock
	Model model;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void shouldAddAnIndividualBill() {
		long billId = 1L;
		when(billRepo.getById(billId)).thenReturn(bill1);
		underTest.findOneBill(billId, model);
		verify(model).addAttribute("bill", bill1);
	}


	@Test
	public void shouldReturnAnIndividualBill() {
		String template = underTest.findOneBill(1L, model);
		assertThat(template, is("bill"));
	}
}