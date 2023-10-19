package crystals.Data;

import java.util.List;

public interface BlurbsRepository {
    crystals.Models.Blurbs addBlurb(crystals.Models.Blurbs blurbs);

    boolean updateBlurb(crystals.Models.Blurbs blurbs);

    boolean deleteBlurbById(int blurbId);

    List<crystals.Models.Blurbs> findAllBlurbs();

    crystals.Models.Blurbs findBlurbById(int blurbId);
}
