package Data;

import crystals.Data.BlurbsJdbcTemplateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
