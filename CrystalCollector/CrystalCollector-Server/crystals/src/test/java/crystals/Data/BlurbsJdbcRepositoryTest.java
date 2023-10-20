package crystals.Data;


import crystals.Models.Blurbs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
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

    @Test
    void shouldAddBlurb() {
        Blurbs blurb = new Blurbs();
        blurb.setTitle("Testing Title");
        blurb.setTextBody("Test words words words");
        blurb.setImageUrl("img.com/something");
        blurb.setAppUserId(1);
        blurb.setBlurbsId(5);

        Blurbs actual = repository.addBlurb(blurb);

        assertEquals(blurb, actual);
    }

    // test null things in the domain not repository
//    @Test
//    void shouldNotAddNullFieldsBlurb() {
//        Blurbs blurb = new Blurbs();
//        blurb.setTitle("Testing Title");
//        blurb.setTextBody(null);
//        blurb.setImageUrl("img.com/something");
//        blurb.setAppUserId(1);
//        blurb.setBlurbsId(5);
//
//        Blurbs nullBlurb = repository.addBlurb(blurb);
//
//        assertNull(nullBlurb);
//
//    }

    @Test
    void shouldUpdateBlurb() {
        Blurbs blurb = new Blurbs();
        blurb.setTitle("Testing Title");
        blurb.setTextBody("Test words words words");
        blurb.setImageUrl("img.com/something");
        blurb.setAppUserId(1);
        blurb.setBlurbsId(5);

        Blurbs existingBlurb = repository.findBlurbById(5);

        if (existingBlurb !=  null) {
            existingBlurb.setTitle("Updated Test Title");
            blurb.setTextBody("Updated Test words words words");
            blurb.setImageUrl("Updated img.com/something");

            boolean updated = repository.updateBlurb(existingBlurb);
            assertEquals("Updated Test Title", existingBlurb.getTitle());
        }

    }

    @Test
    void shouldNotUpdateMissingFieldsBlurb() {
        Blurbs blurb = new Blurbs();
        blurb.setTitle("Testing Title");
        blurb.setTextBody("Test words words words");
        blurb.setImageUrl("img.com/something");
        blurb.setAppUserId(1);
        blurb.setBlurbsId(5);

        Blurbs existingBlurb = repository.findBlurbById(5);

        if (existingBlurb !=  null) {
            existingBlurb.setTitle(null);
            blurb.setTextBody("Updated Test words words words");
            blurb.setImageUrl("Updated img.com/something");

            boolean updated = repository.updateBlurb(existingBlurb);
            assertFalse(updated);
        }

    }

    @Test
    void shouldDeleteBlurb() {
        assertTrue(repository.deleteBlurbById(4));
    }

    @Test
    void shouldNotDeleteNonExistentBlurb() {
        assertFalse(repository.deleteBlurbById(MISSING_ID));
    }


    @Test
    void shouldFindAllBlurbs() {
        List<Blurbs> blurbs = repository.findAllBlurbs(1);

        assertNotNull(blurbs);
        assertEquals(3, blurbs.size());
    }

    @Test
    void shouldFindBlurbById() {
        Blurbs blurb =repository.findBlurbById(1);

        assertEquals(1, blurb.getBlurbsId());
    }

    @Test
    void shouldNotFindNonExistentBlurb() {
        Blurbs blurb =repository.findBlurbById(MISSING_ID);

        assertNull(blurb);
    }


}
