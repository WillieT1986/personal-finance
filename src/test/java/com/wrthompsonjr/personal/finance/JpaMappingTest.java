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
    Income income;

    @Resource
    private TestEntityManager entityManager;

    @Resource
    private UserProfileRepository userProfileRepo;

    @Resource
    private BillRepository billRepo;

    @Resource
    private IncomeRepository incomeRepo;

    @BeforeEach
    public void setUp() {
        userProfile = new UserProfile(USER_FIRST_NAME, USER_MIDDLE_NAME, USER_LAST_NAME, USER_SUFFIX, USER_EMAIL, USER_PHONE, income);
        bill = new Bill(userProfile, "AEP Electric", 50.00, "08", "Monthly", "No");
        income = new Income("Work", 1500.00, "1/1/2014", "Monthly", userProfile);
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
    public void shouldSaveBillToUserProfileRelationship() {
        userProfile = userProfileRepo.save(userProfile);
        long userProfileId = userProfile.getId();

        Bill bill1 = new Bill(userProfile, "AEP Electric", 50.00, "08", "Monthly", "No");
        bill1 = billRepo.save(bill1);

        Bill bill2 = new Bill(userProfile, "AEP Electric", 50.00, "08", "Monthly", "No");
        bill2 = billRepo.save(bill2);

        entityManager.flush();
        entityManager.clear();

        userProfile = userProfileRepo.getById(userProfileId);
        assertThat(userProfile.getBills(), containsInAnyOrder(bill1, bill2));
    }

    @Test
    public void shouldSaveUserProfileToIncomeRelationship() {
        userProfile = userProfileRepo.save(userProfile);
        long userProfileId = userProfile.getId();

        Income income1 = new Income("Work1", 1500.00, "1/1/2014", "Monthly", userProfile);
        income1 = incomeRepo.save(income1);

        Income income2 = new Income("Work2", 1500.00, "1/1/2014", "Monthly", userProfile);
        income2 = incomeRepo.save(income2);

        entityManager.flush();
        entityManager.clear();

        userProfile = userProfileRepo.getById(userProfileId);
        assertThat(userProfile.getIncomes(), containsInAnyOrder(income1, income2));
    }
}