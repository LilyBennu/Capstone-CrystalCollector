package crystals.Data;

import crystals.Models.AppUser;
import crystals.Models.Crystal;
import crystals.Models.CrystalSpecification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CrystalJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public CrystalJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    CRYSTAL *these all need to be tied to a userId*
//    - addCrystal (CREATE)
    public Crystal addCrystal(Crystal crystal) {
        return null;
    }
//    - updateCrystal
    public boolean updateCrystal(Crystal crystal) {
        return false;
    }
//    - removeCrystalById
    public boolean removeCrystalById(int crystalId) {
        return false;
    }
//    - viewAllCrystals
    public Crystal viewAllCrystals(Crystal crystal) {
        return null;
    }

//    - viewCrystalsByInCollection // do I need these or can some kind of
//    - viewCrystalsNotInCollection // sort function in React sort this for me?
    // mwahahahah their are sort functions in React heck yeeeeeeeee
}
