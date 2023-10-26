package crystals.Data;

import crystals.Models.AppUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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
        return jdbcTemplate.query(sql, new AppUserMapper(getAuthorities(username)), username).stream()
                .findFirst().orElse(null);
    }



    @Override
    public AppUser findByAppUserId(int appUserId, String appUserName) {
        String sql = """
                select
                    app_user_id, username, password_hash, enabled
                from app_user
                where app_user_id = ?;
                """;
        return jdbcTemplate.query(sql, new AppUserMapper(getAuthorities(appUserName)), appUserId).stream()
                .findFirst().orElse(null);
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

        updateRoles(appUser);

        return appUser;
    }

    private void updateRoles(AppUser appUser) {
        jdbcTemplate.update("delete from app_user_role where app_user_id = ?;", appUser.getAppUserId());
        for (var authority : appUser.getAuthorities()) {
            String sql = """
                    insert into app_user_role (app_user_id, app_role_id)
                    values (?, (select app_role_id from app_role where app_role_specification = ?));
                    """;
            jdbcTemplate.update(sql, appUser.getAppUserId(), authority.getAuthority());
        }
    }

    private List<String> getAuthorities(String appUserName) {
        final String sql = """
                select 
                    r.app_role_specification
                from app_role r
                inner join app_user_role ur on ur.app_role_id = r.app_role_id
                inner join app_user u on u.app_user_id = ur.app_user_id
                where u.username = ?;
                """;
        return jdbcTemplate.query(sql, (rs, i) -> rs.getString("app_role_specification"), appUserName);
    }


}
