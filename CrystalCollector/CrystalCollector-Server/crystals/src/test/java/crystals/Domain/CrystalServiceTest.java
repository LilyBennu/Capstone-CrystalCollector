package crystals.Domain;

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
    }



    @Test
    void shouldNotAllowColorOverMaxChars() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setColor("ThisColorDescriptionIsTooLongAndExceedsThe25CharacterLimit");

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }

    @Test
    void shouldAllowZeroAmountOwned() {

        Crystal crystal = TestHelper.makeCrystal();
        crystal.setCrystalId(0);
        crystal.setAmountOwned(0);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertTrue(result.isSuccess());
    }


    @Test
    void shouldNotAllowNullShape() {
        Crystal crystal = TestHelper.makeCrystal();
        crystal.setShape(null);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotAllowShapeOverMaxChars() {

        Crystal crystal = TestHelper.makeCrystal();
        String longShape = "ThisIsAReallyLongShapeDescriptionThatExceedsTheFiftyCharacterLimit";
        crystal.setShape(longShape);

        Result<Crystal> result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    }


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

        Result<Crystal> actual = crystalService.addCrystal(null);
        assertFalse(actual.isSuccess());
    }



} // last one don't delete
