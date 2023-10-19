package Data;

import crystals.Data.AppUserJdbcTemplateRepository;
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

//    shouldFindAppUserByUsername
    @Test
    void shouldFindAppUserByUsername() {

        AppUser lily = repository.findByUsername("Lily");
        assertEquals(1, lily.getAppUserId());

    }

//    shouldNotFindNonExistantUsername
//    shouldFindAppUserById
//    shouldNotFindNonExistentAppUser
//    shouldAddAppUser
//    shouldNotAddNullFieldsAppUser
}
