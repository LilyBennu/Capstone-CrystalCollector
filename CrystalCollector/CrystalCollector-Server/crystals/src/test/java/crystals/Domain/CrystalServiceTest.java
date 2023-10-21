package crystals.Domain;
// 2:25 pm
import crystals.Data.CrystalRepository;
import crystals.Models.Crystal;
import crystals.Models.CrystalSpecification;
import crystals.Models.AppUser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import crystals.Domain.TestHelper.*;

import static crystals.Domain.TestHelper.makeCrystal;
import static crystals.Domain.TestHelper.makeResult;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrystalServiceTest {

    @MockBean
    CrystalRepository crystalRepository;

    @Autowired
    CrystalService crystalService;

    @Test
    void shouldNotAllowNullCrystalName() {
        Crystal crystal = TestHelper.makeCrystal();
        crystal.setCrystalName(null);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }
    // angry with string.length for name


    @Test
    void shouldNotAllowCrystalNameOverMaxChars() {

        String longName = "ThisIsAReallyLongCrystalNameThatExceedsFiftyCharactersLimit";
        Crystal crystal = TestHelper.makeCrystal();
        crystal.setCrystalName(longName);


        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotAllowNullColor() {
        Crystal crystal = TestHelper.makeCrystal();
        crystal.setColor(null);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    } // string.length() angry at null color



    @Test
    void shouldNotAllowColorOverMaxChars() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setColor("ThisColorDescriptionIsTooLongAndExceedsThe25CharacterLimit");

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotAllowEmptyAmountOwned() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setCrystalId(0);
        crystal.setAmountOwned(-1);

        Result<Crystal> expected = makeResult("Please enter Amount Owned, if Crystal is Not In Collection put 0", ResultType.INVALID);

        Result<Crystal> actual = crystalService.addCrystal(crystal);

        assertEquals(expected, actual);
    } // fields match but not references


    @Test
    void shouldAllowZeroAmountOwned() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setCrystalId(0);
        crystal.setAmountOwned(0);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertTrue(result.isSuccess());
    } // FINALLY ONE PASSED


    @Test
    void shouldNotAllowNullShape() {
        Crystal crystal = TestHelper.makeCrystal();
        crystal.setShape(null);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    } // string.length() angry with null shape
        // same issue as other Null based tests


    @Test
    void shouldNotAllowShapeOverMaxChars() {

        Crystal crystal = TestHelper.makeCrystal();
        String longShape = "ThisIsAReallyLongShapeDescriptionThatExceedsTheFiftyCharacterLimit";
        crystal.setShape(longShape);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    } // SHE PASSED YAAAAAAAAY


    @Test
    void shouldAllowNullNotes() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setCrystalId(0);
        crystal.setNotes(null);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertTrue(result.isSuccess());
    } // same issue as other Null tests cant invoke .length()


    @Test
    void shouldNotAllowNotesOverMaxChars() {

        StringBuilder longNotes = new StringBuilder();
        while (longNotes.length() < 2050) {
            longNotes.append("A");
        }

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setNotes(longNotes.toString());

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldAllowNullImgUrl() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setImageUrl(null);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertTrue(result.isSuccess());

    } // can't get string.length


    @Test
    void shouldNotAllowImgUrlOverMaxChars() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setImageUrl("https://example.com/" + "x".repeat(251)); // Create a long URL

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotAllowNullCrystalSpecType() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setCrystalSpecification(null);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotAllowMissingAppUser() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setAppUserId(0);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());

        assertTrue(result.getMessages().contains("Internal error"));
    }




    @Test
    void shouldNotAddNullCrystal() {
        Result<Crystal> expected = makeResult("Crystal cannot be null", ResultType.INVALID);
        Result<Crystal> actual = crystalService.addCrystal(null);
        assertFalse(actual.isSuccess());

        assertEquals(expected, actual);
    } // failing but low key for right reasons le sigh



} // last one don't delete
