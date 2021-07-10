package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserProfileTest {

    private static final String FIRST_NAME = "First";
    private static final String MIDDLE_NAME = "Middle";
    private static final String LAST_NAME = "Last";
    private static final String SUFFIX = "II";
    private static final String USER_EMAIL = "Test@wrthompsonjr.com";
    private static final String USER_PHONE_NUMBER = "000-000-0000";

    @Resource
    private UserProfileRepository userProfileRepo;

    @Resource
    private TestEntityManager entityManager;

    UserProfile underTest;
    Income income;

    @BeforeEach
    public void setUp() {
        underTest = new UserProfile(FIRST_NAME, MIDDLE_NAME, LAST_NAME, SUFFIX, USER_EMAIL, USER_PHONE_NUMBER, income);
    }

    @Test
    public void shouldInstantiateUserProfile() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldReturnAUsersFirstNameMiddleNameLastNameAndSuffix() {
        String check_firstName = underTest.getUserFirstName();
        String check_middleName = underTest.getUserMiddleName();
        String check_lastName = underTest.getUserLastName();
        String check_suffix = underTest.getUserSuffix();
        assertEquals(FIRST_NAME, check_firstName);
        assertEquals(MIDDLE_NAME, check_middleName);
        assertEquals(LAST_NAME, check_lastName);
        assertEquals(SUFFIX, check_suffix);
    }

    @Test
    public void shouldReturnUsersEmail() {
        String check = underTest.getUserEmail();
        assertEquals(USER_EMAIL, check);
    }

    @Test
    public void shouldReturnUserPhoneNumber() {
        String check = underTest.getUserPhoneNumber();
        assertEquals(USER_PHONE_NUMBER, check);
    }

    @Test
    public void shouldSaveAndLoadUserProfile() {
        UserProfile userProfileTest = userProfileRepo.save(new UserProfile("John"));
        long userProfileId = userProfileTest.getId();

        entityManager.flush();
        entityManager.clear();

        userProfileTest = userProfileRepo.getById(userProfileId);
        assertThat(userProfileTest.getUserProfile(), is("John"));
    }
}