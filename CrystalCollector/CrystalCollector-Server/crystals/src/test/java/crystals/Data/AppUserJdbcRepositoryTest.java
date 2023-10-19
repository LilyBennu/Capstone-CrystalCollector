package crystals.Data;

import crystals.Models.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AppUserJdbcRepositoryTest {

    static final int MISSING_ID = 100;

    @Autowired
    AppUserJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAppUserByUsername() {

        AppUser lily = repository.findByUsername("TestLily");
        assertEquals(1, lily.getAppUserId());
    }

    @Test
    void shouldNotFindNonExistentUsername() {

        AppUser userNotFound = repository.findByUsername("Lily");

        assertNull(userNotFound);

    }

    @Test
    void shouldFindAppUserById() {

        AppUser lily = repository.findByAppUserId(1);
        assertEquals(1, lily.getAppUserId());
    }

    @Test
    void shouldNotFindNonExistentAppUser() {

        AppUser missingMcGee = repository.findByAppUserId(MISSING_ID);
        assertNull(missingMcGee);

    }

    @Test
    void shouldAddAppUser() {

        AppUser appUser = new AppUser();
        appUser.setAppUserName("Lily");
        appUser.setPasswordHash("aPasswordHash");

        AppUser actual = repository.addAppUser(appUser);
        appUser.setAppUserId(4);
        assertEquals(appUser, actual);
    }

    @Test
    void shouldNotAddNullFieldsAppUser() {

        AppUser appUser = new AppUser();
        appUser.setAppUserName(null);
        appUser.setPasswordHash("aPasswordHash");

        appUser.setAppUserId(4);

        try {
            repository.addAppUser(appUser);
            fail("Expected an exception to be thrown");
        } catch (DataIntegrityViolationException ex) {
            assertTrue(ex.getMessage().contains("Column 'username' cannot be null"));
        }


    }


}
