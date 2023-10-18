package crystals.Data;

import crystals.Models.AppUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class AppUserJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public AppUserJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    - findByUsername
    public AppUser findByUsername(String username) {
        return null;
    }
//    - findById
    public AppUser findByAppUserId(int appUserId) {
        return null;
    }

    // -addAppUser
    public AppUser addAppUser(AppUser appUser) {
        return null;
    }

}
