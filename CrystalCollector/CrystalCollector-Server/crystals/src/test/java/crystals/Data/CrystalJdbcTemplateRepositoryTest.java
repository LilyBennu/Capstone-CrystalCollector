package crystals.Data;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CrystalJdbcTemplateRepositoryTest {


    static final int MISSING_ID = 100;

    @Autowired
    CrystalJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }


//    shouldAddCrystal
//    shouldNotAddMissingFieldsCrystal
//    shouldNotAddCrystalWithoutAppUserId
//    shouldUpdateCrystal
//    shouldNotUpdateMissingFieldsCrystal
//    shouldRemoveCrystal
//    shouldNotRemoveNonExistentCrystal
//    shouldNotRemoveCrystalWithoutAppUserId
//    shouldFindAllCrystalsByUser
//    shouldNotFindCrystalsWithoutAppUserId
//    shouldFindCrystalById
//    shouldNotFindNonExistentCrystal
//    shouldNotFindCrystalWitoutAppUserId


}
