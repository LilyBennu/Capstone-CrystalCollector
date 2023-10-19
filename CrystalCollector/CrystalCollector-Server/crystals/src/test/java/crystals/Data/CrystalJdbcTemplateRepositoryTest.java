package crystals.Data;

import crystals.Models.Crystal;
import crystals.Models.CrystalSpecification;
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

    @Test
    void shouldAddCrystal() {
        Crystal crystal = new Crystal();
        crystal.setCrystalId(4);
        crystal.setCrystalName("Pyrite");
        crystal.setColor("Golden");
        crystal.setAmountOwned(2);
        crystal.setShape("spheres");
        crystal.setNotes("one sit's flat the other on a stand");
        crystal.setRaw(true);
        crystal.setInCollection(true);
        crystal.setImageUrl("exampleUrl.com/image");
        crystal.setCrystalSpecification(CrystalSpecification.SPECIAL);
        crystal.setAppUserId(1);

        Crystal actual = repository.addCrystal(crystal);

        assertEquals(crystal, actual);
    }


    @Test
    void shouldUpdateCrystal() {
        Crystal crystal = new Crystal();
        crystal.setCrystalId(4);
        crystal.setCrystalName("Pyrite");
        crystal.setColor("Golden");
        crystal.setAmountOwned(2);
        crystal.setShape("spheres");
        crystal.setNotes("one sit's flat the other on a stand");
        crystal.setRaw(true);
        crystal.setInCollection(true);
        crystal.setImageUrl("exampleUrl.com/image");
        crystal.setCrystalSpecification(CrystalSpecification.SPECIAL);
        crystal.setAppUserId(1);

        Crystal existingCrystal = repository.findCrystalById(4);

        if (existingCrystal != null) {

            crystal.setCrystalName("UpdatedPyrite");
            crystal.setColor("Golden");
            crystal.setAmountOwned(2);
            crystal.setShape("spheres");
            crystal.setNotes("Also known as fool's gold, one sit's flat the other on a stand");
            crystal.setRaw(true);
            crystal.setInCollection(true);
            crystal.setImageUrl("exampleUrl.com/image");
            crystal.setCrystalSpecification(CrystalSpecification.SPECIAL);

            boolean updated = repository.updateCrystal(existingCrystal);

            assertEquals("UpdatedPyrite", crystal.getCrystalName());

        }

    }

    @Test
    void shouldNotUpdateMissingFieldsCrystal(){
        Crystal crystal = new Crystal();
        crystal.setCrystalId(4);
        crystal.setCrystalName("Pyrite");
        crystal.setColor("Golden");
        crystal.setAmountOwned(2);
        crystal.setShape("spheres");
        crystal.setNotes("one sit's flat the other on a stand");
        crystal.setRaw(true);
        crystal.setInCollection(true);
        crystal.setImageUrl("exampleUrl.com/image");
        crystal.setCrystalSpecification(CrystalSpecification.SPECIAL);
        crystal.setAppUserId(1);

        Crystal existingCrystal = repository.findCrystalById(4);

        if (existingCrystal != null) {

            crystal.setCrystalName(null);
            crystal.setColor("Golden");
            crystal.setAmountOwned(2);
            crystal.setShape("spheres");
            crystal.setNotes("Also known as fool's gold, one sit's flat the other on a stand");
            crystal.setRaw(true);
            crystal.setInCollection(true);
            crystal.setImageUrl("exampleUrl.com/image");
            crystal.setCrystalSpecification(CrystalSpecification.SPECIAL);

            boolean updated = repository.updateCrystal(existingCrystal);

            assertFalse(updated);

        }

    }


    @Test
    void shouldRemoveCrystal() {
        assertTrue(repository.removeCrystalById(3));
    }

    @Test
    void shouldNotRemoveNonExistentCrystal() {
        assertFalse(repository.removeCrystalById(MISSING_ID));
    }

    @Test
    void shouldFindAllCrystalsByUser() {
        List<Crystal> crystals = repository.viewAllCrystals(1);

        assertNotNull(crystals);
    }


    @Test
    void shouldFindCrystalById() {
        Crystal crystal = repository.findCrystalById(1);
        assertEquals(1, crystal.getCrystalId());
        assertEquals("TestAmethyst", crystal.getCrystalName());
    }


    @Test
    void shouldNotFindNonExistentCrystal() {
        Crystal crystal = repository.findCrystalById(MISSING_ID);
        assertNull(crystal);
    }



}
