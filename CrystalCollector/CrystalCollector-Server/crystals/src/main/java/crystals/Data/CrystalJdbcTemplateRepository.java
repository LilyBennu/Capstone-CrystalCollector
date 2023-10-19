package crystals.Data;


import crystals.Models.Crystal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CrystalJdbcTemplateRepository implements CrystalRepository {

    private final JdbcTemplate jdbcTemplate;

    public CrystalJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Crystal addCrystal(Crystal crystal) {

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("crystal")
                .usingColumns("crystal_name, color, amount_owned, shape," +
                        "notes, raw, in_collection,image_url, crystal_specification_id, app_user_id")
                .usingGeneratedKeyColumns("crystal_id");
        HashMap<String, Object> args = new HashMap<>();
        args.put("crystal_name", crystal.getCrystalName());
        args.put("color", crystal.getColor());
        args.put("amount_owned", crystal.getAmountOwned());
        args.put("shape", crystal.getShape());
        args.put("notes", crystal.getNotes());
        args.put("raw", crystal.isRaw());
        args.put("in_collection", crystal.isInCollection());
        args.put("image_url", crystal.getImageUrl());
        args.put("crystal_specification_id", crystal.getCrystalSpecification());
        args.put("app_user_id",crystal.getAppUserId());

        int crystalId = insert.executeAndReturnKey(args).intValue();
        crystal.setCrystalId(crystalId);

        return crystal;
    }
//    - updateCrystal
    @Override
    public boolean updateCrystal(Crystal crystal) {
        String sql = """
                update crystal set
                    crystal_name = ?,
                    color = ?,
                    amount_owned = ?,
                    shape = ?,
                    notes = ?,
                    raw = ?,
                    in_collection = ?,
                    image_url = ?,
                    crystal_specification =?,
                    app_user_id = ?
                where crystal_id = ? AND app_user_id = ?;
                """;
        return jdbcTemplate.update(sql,
                crystal.getCrystalName(),
                crystal.getColor(),
                crystal.getAmountOwned(),
                crystal.getShape(),
                crystal.getNotes(),
                crystal.isRaw(),
                crystal.isInCollection(),
                crystal.getImageUrl(),
                crystal.getCrystalSpecification(),
                crystal.getAppUserId(),
                crystal.getCrystalId()) > 0;
    }

@Override
public boolean removeCrystalById(int crystalId) {

    String sql = """
                delete from crystal
                where crystal_id = ? AND app_user_id = ?;
                """;

    return jdbcTemplate.update(sql, crystalId) > 0;
}

@Override
public List<Crystal> viewAllCrystals() {

    String sql = """
                select * from crystal
                where app_user_id = ?;
                """;
    return jdbcTemplate.query(sql, new CrystalMapper());
}


    @Override
    public Crystal findCrystalById(int blurbId) {

        String sql = """
                select * from crystal
                where crystal_id = ? AND app_user_id = ?;
                """;
        return jdbcTemplate.query(sql, new CrystalMapper(), blurbId).stream().findFirst().orElse(null);
    }


}
