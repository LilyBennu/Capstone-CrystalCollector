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

            Result<Crystal> result = validateUpdateCrystal(crystal);
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

        private Result<Crystal> validateAddCrystal(Crystal crystal) {
            Result<Crystal> result = new Result<>();

            if (crystal == null) {
                result.addMessage("Crystal cannot be null", ResultType.INVALID);
            }
            if (crystal.getCrystalName() == null) {
                result.addMessage("Please enter Crystal name", ResultType.INVALID);
            }
            if (crystal.getCrystalName().length() > 50) {
                result.addMessage("Crystal name cannot exceed 250 characters", ResultType.INVALID);
            }
            if (crystal.getColor() == null) {
                result.addMessage("Please enter Crystal color", ResultType.INVALID);
            }
            if (crystal.getColor().length() > 25) {
                result.addMessage("Crystal color description cannot exceed 25 characters", ResultType.INVALID);
            }
            if (crystal.getAmountOwned() < 0) {
                result.addMessage("Please enter Amount Owned, if Crystal is Not In Collection put 0", ResultType.INVALID);
            }
            if (crystal.getShape() == null) {
                result.addMessage("Please enter Crystal shape", ResultType.INVALID);
            }
            if (crystal.getShape().length() > 25) {
                result.addMessage("Crystal shape description cannot exceed 25 characters", ResultType.INVALID);
            }
            if (crystal.getNotes().length() > 2048) {
                result.addMessage("Crystal note cannot exceed 2048 characters", ResultType.INVALID);
            }
            if (crystal.getImageUrl().length() > 250) {
                result.addMessage("Image URL has exceeded character limit", ResultType.INVALID);
            }
            // how do i do is null statement for boolean?? is it possible
            if (crystal.getCrystalSpecification() == null) {
                result.addMessage("Please choose a Crystal Specification Type", ResultType.INVALID);
            }
            if (crystal.getAppUserId() <= 0) {
                result.addMessage("Internal error", ResultType.NOT_FOUND);
            }


            return result;
        }

//        crystal_id, crystal_name, color, amount_owned, shape,
//        notes, raw, in_collection,
//        image_url, crystal_specification_id, app_user_id

        private Result<Crystal> validateUpdateCrystal(Crystal crystal) {
            Result<Crystal> result = new Result<>();

           if (crystal.getCrystalName() == null) {
               result.addMessage("Please enter Crystal name", ResultType.INVALID);
           }
           if (crystal.getCrystalName().length() > 50) {
               result.addMessage("Crystal name cannot exceed 250 characters", ResultType.INVALID);
           }
           if (crystal.getColor() == null) {
               result.addMessage("Please enter Crystal color", ResultType.INVALID);
           }
           if (crystal.getColor().length() > 25) {
               result.addMessage("Crystal color description cannot exceed 25 characters", ResultType.INVALID);
           }
           if (crystal.getAmountOwned() < 0) {
               result.addMessage("Please enter Amount Owned, if Crystal is Not In Collection put 0", ResultType.INVALID);
           }
           if (crystal.getShape() == null) {
               result.addMessage("Please enter Crystal shape", ResultType.INVALID);
           }
           if (crystal.getShape().length() > 25) {
               result.addMessage("Crystal shape description cannot exceed 25 characters", ResultType.INVALID);
           }
           if (crystal.getNotes().length() > 2048) {
               result.addMessage("Crystal note cannot exceed 2048 characters", ResultType.INVALID);
           }
           if (crystal.getImageUrl().length() > 250) {
               result.addMessage("Image URL has exceeded character limit", ResultType.INVALID);
           }
           // how do i do is null statement for boolean?? is it possible
            if (crystal.getCrystalSpecification() == null) {
                result.addMessage("Please choose a Crystal Specification Type", ResultType.INVALID);
            }
            if (crystal.getAppUserId() <= 0) {
                result.addMessage("Internal error", ResultType.NOT_FOUND);
            }

            return result;
        }

        private Result<Crystal> validateCrystals(Crystal crystal) {
            Result<Crystal> result = new Result<>();

            if (crystal.getAppUserId() <= 0) {
                result.addMessage("Internal error", ResultType.NOT_FOUND);
            }
            return result;
        }
    }
