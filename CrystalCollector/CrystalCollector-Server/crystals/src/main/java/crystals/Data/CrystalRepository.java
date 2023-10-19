package crystals.Data;

import java.util.List;

public interface CrystalRepository {

    crystals.Models.Crystal addCrystal(crystals.Models.Crystal crystal);

    boolean updateCrystal(crystals.Models.Crystal crystal);

    boolean removeCrystalById(int crystalId);

    List<crystals.Models.Crystal> viewAllCrystals();

    crystals.Models.Crystal findCrystalById(int blurbId);
}
