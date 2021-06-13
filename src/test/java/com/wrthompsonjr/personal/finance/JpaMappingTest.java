package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaMappingTest {

    @Resource
    private TestEntityManager entityManager;

    @Resource
    private UserProfileRepository userProfileRepo;

    @Test
    public void shouldSaveAndLoadUserProfile() {
        UserProfile userProfile = new UserProfile("firstName", "middleName", "lastName", "II", "Test@Gmail.com", "000-000-0000");
        userProfile = userProfileRepo.save(userProfile);
        Long userProfileId = userProfile.getId();

        entityManager.flush();
        entityManager.clear();

        userProfile = userProfileRepo.getById(userProfileId);
        assertThat(userProfile.getUserFirstName(), is("firstName"));
    }

}