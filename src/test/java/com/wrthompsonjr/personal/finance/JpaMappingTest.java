package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaMappingTest {

    private static final String USER_FIRST_NAME = "firstName";
    private static final String USER_MIDDLE_NAME = "middleName";
    private static final String USER_LAST_NAME = "lastName";
    private static final String USER_SUFFIX = "II";
    private static final String USER_EMAIL = "Gmail";
    private static final String USER_PHONE = "000-000-0000";

    UserProfile userProfile;
    Bill bill;
    Financial_Institution financial_institution;

    @Resource
    private TestEntityManager entityManager;

    @Resource
    private UserProfileRepository userProfileRepo;

    @Resource
    private BillRepository billRepository;

    @Resource
    private Financial_Institution_Repository financialRepo;

    @BeforeEach
    public void setUp() {
        userProfile = new UserProfile(USER_FIRST_NAME, USER_MIDDLE_NAME, USER_LAST_NAME, USER_SUFFIX, USER_EMAIL, USER_PHONE, bill, financial_institution);
        bill = new Bill("AEP Electric", 50.00, "08", "Monthly", "No");
        financial_institution = new Financial_Institution("USAA", "Bank", "Checking Account");
    }

    @Test
    public void shouldSaveAndLoadUserProfile() {
        userProfile = userProfileRepo.save(userProfile);
        long userProfileId = userProfile.getId();

        entityManager.flush();
        entityManager.clear();

        userProfile = userProfileRepo.getById(userProfileId);
        assertThat(userProfile.getUserFirstName(), is(USER_FIRST_NAME));
    }

    @Test
    public void shouldSaveUserProfileToBillRelationship() {
        Bill bill = new Bill("AEP Electric", 50.00, "08", "Monthly", "No");
        billRepository.save(bill);
        long billId = bill.getId();

        UserProfile userProfile1 = new UserProfile(USER_FIRST_NAME, USER_MIDDLE_NAME, USER_LAST_NAME, USER_SUFFIX, USER_EMAIL, USER_PHONE, bill, financial_institution);
        userProfile1 = userProfileRepo.save(userProfile1);

        UserProfile userProfile2 = new UserProfile(USER_FIRST_NAME, USER_MIDDLE_NAME, USER_LAST_NAME, USER_SUFFIX, USER_EMAIL, USER_PHONE, bill, financial_institution);
        userProfile2 = userProfileRepo.save(userProfile2);

        entityManager.flush();
        entityManager.clear();

        bill = billRepository.getById(billId);
        assertThat(bill.getUserProfiles(), containsInAnyOrder(userProfile1, userProfile2));
    }

    @Test
    public void shouldSaveUserProfileToFinancialRelationship() {
        Financial_Institution financial_institution = new Financial_Institution("USAA", "Bank", "Checking Account");
        financialRepo.save(financial_institution);
        long financialInstitutionId = financial_institution.getId();

        UserProfile userProfile1 = new UserProfile(USER_FIRST_NAME, USER_MIDDLE_NAME, USER_LAST_NAME, USER_SUFFIX, USER_EMAIL, USER_PHONE, bill, financial_institution);
        userProfile1 = userProfileRepo.save(userProfile1);

        UserProfile userProfile2 = new UserProfile(USER_FIRST_NAME, USER_MIDDLE_NAME, USER_LAST_NAME, USER_SUFFIX, USER_EMAIL, USER_PHONE, bill, financial_institution);
        userProfile2 = userProfileRepo.save(userProfile2);

        entityManager.flush();
        entityManager.clear();

        financial_institution = financialRepo.getById(financialInstitutionId);
        assertThat(financial_institution.getUserProfiles(), containsInAnyOrder(userProfile1, userProfile2));
    }
}