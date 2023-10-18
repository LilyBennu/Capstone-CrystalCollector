package crystals.Data;

import crystals.Models.AppUser;
import crystals.Models.Blurbs;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlurbsJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public BlurbsJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    - addBlurb
    public Blurbs addBlurb(Blurbs blurbs) {
        return null;
    }
//    - updateBlurb
    public boolean updateBlurb(Blurbs blurbs) {
        return false;
    }
//    - deleteBlurbById
    public boolean deleteBlurbById(int blurbId) {
        return false;
    }
//    - findAllBlurbs
    public List<Blurbs> findAllBlurbs() {
        return null;
    }

    // - findBlurbById
    public Blurbs findBlurbById(int blurbId) {
        return null;
    }

}
