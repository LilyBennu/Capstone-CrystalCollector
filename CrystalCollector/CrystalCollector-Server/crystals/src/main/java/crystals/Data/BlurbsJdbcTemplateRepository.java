package crystals.Data;

import crystals.Models.Blurbs;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlurbsJdbcTemplateRepository implements BlurbsRepository {

    private final JdbcTemplate jdbcTemplate;

    public BlurbsJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Blurbs addBlurb(Blurbs blurbs) {

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("blurbs")
                .usingColumns("title, text_body, image_url, app_user_id")
                .usingGeneratedKeyColumns("blurbs_id");
        HashMap<String, Object> args = new HashMap<>();
        args.put("title", blurbs.getTitle());
        args.put("text_body", blurbs.getTextBody());
        args.put("image_url", blurbs.getImageUrl());
        args.put("app_user_id", blurbs.getAppUserId());

        int blurbsId = insert.executeAndReturnKey(args).intValue();
        blurbs.setBlurbsId(blurbsId);

        return blurbs;
    }


    @Override
    public boolean updateBlurb(Blurbs blurbs) {

        String sql = """
                update blurbs set
                    title = ?,
                    text_body =?,
                    image_url = ?,
                    app_user_id
                where blurbs_id = ? AND app_user_id = ?;
                """;

        boolean updated = jdbcTemplate.update(sql,
                blurbs.getTitle(),
                blurbs.getTextBody(),
                blurbs.getImageUrl(),
                blurbs.getAppUserId(),
                blurbs.getBlurbsId()) > 0;
        return updated;
    }


    @Override
    public boolean deleteBlurbById(int blurbId) {

        String sql = """
                delete from blurbs
                where blurbs_id = ? AND app_user_id = ?;
                """;

        return jdbcTemplate.update(sql, blurbId) > 0;
    }


    @Override
    public List<Blurbs> findAllBlurbs() {

        String sql = """
                select * from blurbs
                where app_user_id = ?;
                """;
        return jdbcTemplate.query(sql, new BlurbsMapper());
    }


    @Override
    public Blurbs findBlurbById(int blurbId) {

        String sql = """
                select
                    blurbs_id, title, text_body, image_url, app_user_id
                from blurbs
                where blurbs_id = ? AND app_user_id = ?;
                """;
        return jdbcTemplate.query(sql, new BlurbsMapper(), blurbId).stream().findFirst().orElse(null);
    }

}
