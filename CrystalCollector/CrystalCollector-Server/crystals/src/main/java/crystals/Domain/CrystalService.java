package crystals.Domain;

import crystals.Data.CrystalRepository;
import crystals.Models.Crystal;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class CrystalService {

        private final CrystalRepository crystalRepository;

        public CrystalService(CrystalRepository crystalRepository) {
            this.crystalRepository = crystalRepository;
        }

        public Result<Crystal> addCrystal(Crystal crystal) {

            Result<Crystal> result = validateAddCrystal(crystal);
            if (!result.isSuccess()) {
                return result;
            }

            if ((crystal.getCrystalId() != 0)) {
                result.addMessage("Crystal id cannot be set for add operation");
                return result;
            }

            if (result.isSuccess()) {
                Crystal newCrystal = crystalRepository.addCrystal(crystal);
                result.setPayload(newCrystal);
            }
            return result;
        }
//
//    boolean updateCrystal(Crystal crystal);
        public Result<Crystal> updateCrystal(Crystal crystal) {

            Result<Crystal> result = validateUpdateCrystal(crystal);
            if (!result.isSuccess()) {
                return result;
            }

            if (crystal.getCrystalId() <= 0) {
                result.addMessage("Crystal id is required");
                return  result;
            }

            boolean success = crystalRepository.updateCrystal(crystal);

            if (!success) {
                result.addMessage("Could not update Crystal id" + crystal.getCrystalId());
            }

            return result;
        }

        public Result<Void> removeCrystalById(int crystalId) {
            Result<Void> result = new Result<>();

            boolean success = crystalRepository.removeCrystalById(crystalId);
            if (!success) {
                result.addMessage("Could not remove crystal id " + crystalId);
            }
            return result;
        }

        public List<Crystal> viewAllCrystals(int appUserId) {
            return crystalRepository.viewAllCrystals(appUserId);
        }

        public Crystal findCrystalById(int crystalId) {
            return crystalRepository.findCrystalById(crystalId);
        }

        private Result<Crystal> validateAddCrystal(Crystal crystal) {
            Result<Crystal> result = new Result<>();

            // if statements for validating Add crystal to collection
            return result;
        }

        private Result<Crystal> validateUpdateCrystal(Crystal crystal) {
            Result<Crystal> result = new Result<>();

            // if statements for validating Update crystal to collection
            return result;
        }

        private Result<Crystal> validateCrystals(Crystal crystal) {
            Result<Crystal> result = new Result<>();

            // if statements for validating Update crystal to collection
            return result;
        }
    }
