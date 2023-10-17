package crystals.Data;

import crystals.Models.AppUser;
import crystals.Models.Blurbs;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserMapper implements RowMapper<AppUser> {


    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        AppUser appUser = new AppUser();

        appUser.setAppUserId(rs.getInt("app_user_id"));
        appUser.setAppUserName(rs.getString("username"));
        appUser.setPasswordHash(rs.getString("password_hash"));
        appUser.setEnabled(rs.getBoolean("enabled"));

        return appUser;
    }
}
