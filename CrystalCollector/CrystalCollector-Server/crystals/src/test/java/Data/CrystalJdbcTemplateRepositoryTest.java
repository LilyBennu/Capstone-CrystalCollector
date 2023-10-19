package Data;

import crystals.Data.CrystalJdbcTemplateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
