package crystals.Domain;

import crystals.Data.BlurbsRepository;
import crystals.Models.Blurbs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class BlurbService {

        private final BlurbsRepository blurbsRepository;

        public BlurbService(BlurbsRepository blurbsRepository) {
            this.blurbsRepository = blurbsRepository;
        }

//    addBlurb(crystals.Models.Blurbs blurbs);
        public Result<Blurbs> addBlurb(Blurbs blurbs) {

            Result<Blurbs> result = validateAddBlurb(blurbs);

            if (!result.isSuccess()) {
                return result;
            }

            if (blurbs.getBlurbsId() != 0) {
                result.addMessage("Blurb id cannot be set for Add operation");
                return result;
            }

            if (result.isSuccess()) {
                Blurbs newBlurb = blurbsRepository.addBlurb(blurbs);
                result.setPayload(newBlurb);
            }

            // add statement about userId here??? or in validate method?

            return result;
        }


        public Result<Blurbs> updateBlurbs(Blurbs blurbs) {
            Result<Blurbs> result = validateUpdateBlurb(blurbs);

            if (!result.isSuccess()) {
                return result;
            }

            if (blurbs.getBlurbsId() <= 0) {
                result.addMessage("Blurb id is required");
                return result;
            }

            boolean success = blurbsRepository.updateBlurb(blurbs);
            if (!success) {
                result.addMessage("Could not update blurb id " + blurbs.getBlurbsId());
            }
            return result;
        }
//
//    boolean deleteBlurbById(int blurbId);

        public Result<Void> deleteBlurbById(int blurbId) {
            Result<Void> result = new Result<>();

            boolean success = blurbsRepository.deleteBlurbById(blurbId);
            if (!success) {
                result.addMessage("Could not delete blurb id " + blurbId);
            }
            return result;
        }


        public List<Blurbs> findAllBlurbs(int appUserId) {
            return blurbsRepository.findAllBlurbs(appUserId);
        }


        public Blurbs findBlurbById(int blurbsId) {
            return blurbsRepository.findBlurbById(blurbsId);
        }

        private Result<Blurbs> validateAddBlurb(Blurbs blurbs) {
            Result<Blurbs> result = new Result<>();
            //do all if statement validations here

            return result;
        }

        private Result<Blurbs> validateUpdateBlurb(Blurbs blurbs) {
            Result<Blurbs> result = new Result<>();
            //do all if statement validations here

            return result;
        }

    private Result<Blurbs> validateBlurbs(Blurbs blurbs) {
        Result<Blurbs> result = new Result<>();
        //do all if statement validations here

        return result;
    }
    }
