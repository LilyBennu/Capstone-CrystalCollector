package crystals.Data;

import crystals.Models.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void shouldNotFindNonExistantUsername() {

        AppUser userNotFound = repository.findByUsername("Lily");

        assertNull(userNotFound);

    } // something is wrong with my known good state is not passing consistently

@Test
void shouldFindAppUserById() {

    AppUser lily = repository.findByAppUserId(1);
    assertEquals(1, lily.getAppUserId());
}

//    shouldNotFindNonExistentAppUser
@Test
void shouldNotFindNonExistentAppUser() {

    AppUser missingMcGee = repository.findByAppUserId(MISSING_ID);
    assertNull(missingMcGee);

}

//    shouldAddAppUser
//    shouldNotAddNullFieldsAppUser
}
