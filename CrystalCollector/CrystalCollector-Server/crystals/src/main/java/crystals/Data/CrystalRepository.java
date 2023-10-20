package crystals.Data;

import crystals.Models.Crystal;

import java.util.List;

public interface CrystalRepository {

    crystals.Models.Crystal addCrystal(crystals.Models.Crystal crystal);

    boolean updateCrystal(crystals.Models.Crystal crystal);

    boolean removeCrystalById(int crystalId);

    List<crystals.Models.Crystal> viewAllCrystals(int appUserId);

    crystals.Models.Crystal findCrystalById(int crystalId);
}
