package crystals.Data;

import crystals.Models.AppUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AppUserJdbcTemplateRepository implements AppUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public AppUserJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
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


    @Override
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


    @Override
    public AppUser addAppUser(AppUser appUser) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("app_user")
                .usingColumns("username", "password_hash", "enabled")
                .usingGeneratedKeyColumns("app_user_id");

        HashMap<String, Object> args = new HashMap<>();
        args.put("username", appUser.getAppUserName());
        args.put("password_hash", appUser.getPasswordHash());
        args.put("enabled", appUser.isEnabled());

        int id = insert.executeAndReturnKey(args).intValue();
        appUser.setAppUserId(id);

        return appUser;
    }

}
