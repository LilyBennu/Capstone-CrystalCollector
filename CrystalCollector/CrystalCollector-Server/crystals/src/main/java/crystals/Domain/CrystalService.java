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

            Result<Crystal> result = validateCrystal(crystal);
            if (!result.isSuccess()) {
                return result;
            }

            if ((crystal.getCrystalId() != 0)) {
                result.addMessage("Crystal id cannot be set for add operation", ResultType.INVALID);
                return result;
            }

            if (result.isSuccess()) {
                Crystal newCrystal = crystalRepository.addCrystal(crystal);
                result.setPayload(newCrystal);
            }
            return result;
        }

        public Result<Crystal> updateCrystal(Crystal crystal) {

            Result<Crystal> result = validateCrystal(crystal);
            if (!result.isSuccess()) {
                return result;
            }

            if (crystal.getCrystalId() <= 0) {
                result.addMessage("Crystal id is required", ResultType.INVALID);
                return  result;
            }

            boolean success = crystalRepository.updateCrystal(crystal);

            if (!success) {
                result.addMessage("Could not update Crystal id" + crystal.getCrystalId(), ResultType.INVALID);
            }

            return result;
        }

        public Result<Void> removeCrystalById(int crystalId) {
            Result<Void> result = new Result<>();

            boolean success = crystalRepository.removeCrystalById(crystalId);
            if (!success) {
                result.addMessage("Could not remove crystal id " + crystalId, ResultType.INVALID);
            }
            return result;
        }

        public List<Crystal> viewAllCrystals(int appUserId) {
            return crystalRepository.viewAllCrystals(appUserId);
        }

        public Crystal findCrystalById(int crystalId) {
            return crystalRepository.findCrystalById(crystalId);
        }

        private Result<Crystal> validateCrystal(Crystal crystal) {
            Result<Crystal> result = new Result<>();

            if (crystal == null) {
                result.addMessage("Crystal cannot be null", ResultType.INVALID);
                return result;
            }
            if (crystal.getCrystalName() == null) {
                result.addMessage("Please enter Crystal name", ResultType.INVALID);
                return result;
            }
            if (crystal.getCrystalName().length() > 50) {
                result.addMessage("Crystal name cannot exceed 50 characters", ResultType.INVALID);
                return result;
            }
            if (crystal.getColor() == null) {
                result.addMessage("Please enter Crystal color", ResultType.INVALID);
                return result;
            }
            if (crystal.getColor().length() > 25) {
                result.addMessage("Crystal color description cannot exceed 25 characters", ResultType.INVALID);
                return result;
            }
            if (crystal.getAmountOwned() < 0) {
                result.addMessage("Please enter Amount Owned, if Crystal is Not In Collection put 0", ResultType.INVALID);
                return result;
            }
            if (crystal.getShape() == null) {
                result.addMessage("Please enter Crystal shape", ResultType.INVALID);
                return result;
            }
            if (crystal.getShape().length() > 25) {
                result.addMessage("Crystal shape description cannot exceed 25 characters", ResultType.INVALID);
                return result;
            }
            if (crystal.getNotes().length() > 2048) {
                result.addMessage("Crystal note cannot exceed 2048 characters", ResultType.INVALID);
                return result;
            }
            if (crystal.getImageUrl().length() > 250) {
                result.addMessage("Image URL has exceeded character limit", ResultType.INVALID);
                return result;
            }

            if (crystal.getCrystalSpecification() == null) {
                result.addMessage("Please choose a Crystal Specification Type", ResultType.INVALID);
                return result;
            }
            if (crystal.getAppUserId() <= 0) {
                result.addMessage("Internal error", ResultType.NOT_FOUND);
                return result;
            }

            return result;
        }



    }
