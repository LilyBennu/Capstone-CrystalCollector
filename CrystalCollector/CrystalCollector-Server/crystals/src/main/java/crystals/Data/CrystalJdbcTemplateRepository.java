package crystals.Data;


import crystals.Models.Crystal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
public class CrystalJdbcTemplateRepository implements CrystalRepository {

    private final JdbcTemplate jdbcTemplate;

    public CrystalJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public Crystal addCrystal(Crystal crystal) {

        int crystalSpecifcationId = jdbcTemplate.queryForObject("select crystal_specification_id from" +
                " crystal_specification where crystal_type = ?;", Integer.class, crystal.getCrystalSpecification().toString());

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("crystal")
                .usingColumns("crystal_name", "color", "amount_owned", "shape",
                        "notes", "raw", "in_collection","image_url", "crystal_specification_id", "app_user_id")
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
        args.put("crystal_specification_id", crystalSpecifcationId);
        args.put("app_user_id",crystal.getAppUserId());

        int crystalId = insert.executeAndReturnKey(args).intValue();
        crystal.setCrystalId(crystalId);

        return crystal;
    }

    @Override
    public boolean updateCrystal(Crystal crystal) {

        int crystalSpecifcationId = jdbcTemplate.queryForObject("select crystal_specification_id from" +
                " crystal_specification where crystal_type = ?;", Integer.class, crystal.getCrystalSpecification().toString());

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
                    crystal_specification_id =?
                
                where crystal_id = ?;
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
                crystalSpecifcationId,

                crystal.getCrystalId()) > 0;
    }

@Override
public boolean removeCrystalById(int crystalId) {

    String sql = """
                delete from crystal
                where crystal_id = ?;
                """;

    return jdbcTemplate.update(sql, crystalId) > 0;
}

@Override
public List<Crystal> viewAllCrystals(int appUserId) {

    String sql = """
            select
                c.crystal_id, c.crystal_name, c.color, c.amount_owned, c.shape, c.notes, c.raw, c.in_collection,\s
                   c.image_url, c.crystal_specification_id, c.app_user_id, cs.crystal_type    \s
            from crystal c
            inner join crystal_specification cs on c.crystal_specification_id = cs.crystal_specification_id
            where c.app_user_id = ?;
            """;
    return jdbcTemplate.query(sql, new CrystalMapper(), appUserId);
}


    @Override
    public Crystal findCrystalById(int crystalId) {

        String sql = """
                select
                    c.crystal_id, c.crystal_name, c.color, c.amount_owned, c.shape, c.notes, c.raw, c.in_collection,\s
                       c.image_url, c.crystal_specification_id, c.app_user_id, cs.crystal_type
                from crystal c
                inner join crystal_specification cs on c.crystal_specification_id = cs.crystal_specification_id
                where c.crystal_id = ?;
                """;
        return jdbcTemplate.query(sql, new CrystalMapper(), crystalId).stream().findFirst().orElse(null);
    }


}
