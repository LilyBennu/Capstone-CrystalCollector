package crystals.Domain;

import crystals.Data.BlurbsRepository;
import crystals.Models.Blurbs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class BlurbsService {

        private final BlurbsRepository blurbsRepository;

        public BlurbsService(BlurbsRepository blurbsRepository) {
            this.blurbsRepository = blurbsRepository;
        }

//    addBlurb(crystals.Models.Blurbs blurbs);
        public Result<Blurbs> addBlurb(Blurbs blurbs) {

            Result<Blurbs> result = validateBlurb(blurbs);

            if (!result.isSuccess()) {
                return result;
            }

            if (blurbs.getBlurbsId() != 0) {
                result.addMessage("Blurb id cannot be set for Add operation", ResultType.INVALID);
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
            Result<Blurbs> result = validateBlurb(blurbs);

            if (!result.isSuccess()) {
                return result;
            }

            if (blurbs.getBlurbsId() <= 0) {
                result.addMessage("Blurb id is required", ResultType.INVALID);
                return result;
            }

            boolean success = blurbsRepository.updateBlurb(blurbs);
            if (!success) {
                result.addMessage("Could not update blurb id " + blurbs.getBlurbsId(), ResultType.INVALID);
            }
            return result;
        }


        public Result<Void> deleteBlurbById(int blurbId) {
            Result<Void> result = new Result<>();


            boolean success = blurbsRepository.deleteBlurbById(blurbId);
            if (!success) {
                result.addMessage("Could not delete blurb id " + blurbId, ResultType.INVALID);
            }
            return result;
        }


        public List<Blurbs> findAllBlurbs(int appUserId) {
            return blurbsRepository.findAllBlurbs(appUserId);
        }


        public Blurbs findBlurbById(int blurbsId) {
            return blurbsRepository.findBlurbById(blurbsId);
        }

        private Result<Blurbs> validateBlurb(Blurbs blurbs) {
            Result<Blurbs> result = new Result<>();
            if (blurbs == null) {
                result.addMessage("Blurb cannot be null", ResultType.INVALID);
                return result;
            }
            if (blurbs.getTitle() == null) {
                result.addMessage("Please enter a Title", ResultType.INVALID);
                return result;
            }
            if (blurbs.getTextBody() == null) {
                result.addMessage("Please enter text", ResultType.INVALID);
                return result;
            }
            if (blurbs.getAppUserId() <= 0) {
                result.addMessage("User id is required", ResultType.INVALID);
                return result;
            }
            if (blurbs.getTextBody().length() > 2048) {
                result.addMessage("Text body cannot exceed 2048 characters", ResultType.INVALID);
                return result;
            }
            if (blurbs.getTitle().length() > 250) {
                result.addMessage("Title cannot exceed 250 characters", ResultType.INVALID);
                return result;
            }
            if (blurbs.getAppUserId() <= 0) {
                result.addMessage("Internal error", ResultType.NOT_FOUND);
                return result;
            }
            if (blurbs.getImageUrl().length() > 500) {
                result.addMessage("Image URL has exceeded character limit", ResultType.INVALID);
                return result;
            }

            return result;
        }


    }
