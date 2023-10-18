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

        String sql = """
                select
                    app_user_id, username, password_hash, enabled
                from app_user
                where username = ?;
                """;
        return jdbcTemplate.query(sql, new Object[]{username}, new AppUserMapper()).stream()
                .findFirst()
                .orElse(null);
    }
//    - findById
    public AppUser findByAppUserId(int appUserId) {
        String sql = """
                select
                    app_user_id, username, password_hash, enabled
                from app_user
                where app_user_id = ?;
                """;
        return jdbcTemplate.query(sql, new Object[]{appUserId}, new AppUserMapper()).stream()
                .findFirst()
                .orElse(null);
    }

    // -addAppUser
    public AppUser addAppUser(AppUser appUser) {
        return null;
    }

}
