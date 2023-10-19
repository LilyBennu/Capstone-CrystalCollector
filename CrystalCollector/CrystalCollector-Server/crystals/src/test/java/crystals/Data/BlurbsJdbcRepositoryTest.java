package crystals.Data;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BlurbsJdbcRepositoryTest {

    static final int MISSING_ID = 100;

    @Autowired
    BlurbsJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }


//    shouldAddBlurb
//    shouldNotAddNullFieldsBlurb
//    shouldNotAddBlurbWithoutAppUserId
//    shouldUpdateBlurb
//    shouldNotUpdateMissingFieldsBlurb
//    shouldDeleteBlurb
//    shouldNotDeleteNonExistentBlurb
//    shouldNotDeleteBlurbWithoutAppUserId
//    shouldFindAllBlurbs
//    shouldNotFindBlurbsWithoutAppUserId
//    shouldFindBlurbById
//    shouldNotFindNonExistentBlurb
//    shouldNotFindBlurbWithoutAppUserId



}
