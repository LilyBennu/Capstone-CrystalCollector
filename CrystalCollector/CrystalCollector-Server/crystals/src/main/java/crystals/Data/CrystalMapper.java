package crystals.Data;

import crystals.Models.Blurbs;
import crystals.Models.Crystal;
import crystals.Models.CrystalSpecification;
import crystals.Models.AppUser;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CrystalMapper implements RowMapper<Crystal> {

    @Override
    public Crystal mapRow(ResultSet rs, int rowNum) throws SQLException {

        Crystal crystal = new Crystal();

        crystal.setCrystalId(rs.getInt("crystal_id"));
        crystal.setCrystalName(rs.getString("crystal_name"));
        crystal.setColor(rs.getString("color"));
        crystal.setAmountOwned(rs.getInt("amount_owned"));
        crystal.setShape(rs.getString("shape"));
        crystal.setNotes(rs.getString("notes"));
        crystal.setRaw(rs.getBoolean("raw"));
        crystal.setInCollection(rs.getBoolean("in_collection"));
        crystal.setCrystalSpecification(CrystalSpecification.valueOf(rs.getString("crystal_type")));
        crystal.setImageUrl(rs.getString("image_url"));
        crystal.setAppUserId(rs.getInt("app_user_id"));

        return crystal;
    }
}
