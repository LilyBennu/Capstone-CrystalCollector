package crystals.Data;

import crystals.Models.AppUser;
import crystals.Models.Blurbs;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlurbsMapper implements RowMapper<Blurbs> {


    @Override
    public Blurbs mapRow(ResultSet rs, int rowNum) throws SQLException {

        Blurbs blurbs = new Blurbs();


        blurbs.setBlurbsId(rs.getInt("blurbs_id"));
        blurbs.setTitle(rs.getString("title"));
        blurbs.setTextBody(rs.getString("text_body"));
        blurbs.setImageUrl(rs.getString("image_url"));
        blurbs.setAppUserId(rs.getInt("app_user_id"));

        return blurbs;
    }
}
