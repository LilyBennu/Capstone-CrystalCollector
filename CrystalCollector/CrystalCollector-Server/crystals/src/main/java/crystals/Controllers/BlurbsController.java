package crystals.Controllers;

import crystals.Domain.Result;
import crystals.Domain.ResultType;
import crystals.Models.AppUser;
import crystals.Models.Blurbs;
import crystals.Domain.BlurbsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crystals")
public class BlurbsController {

    private final BlurbsService blurbsService;

    public BlurbsController(BlurbsService blurbsService) {
        this.blurbsService = blurbsService;
    }


    @PostMapping("/blurbs/add")
    public ResponseEntity<Result<Blurbs>> addBlurb(@AuthenticationPrincipal AppUser appUser, @RequestBody Blurbs blurbs) {
        blurbs.setAppUserId(appUser.getAppUserId());

        Result<Blurbs> blurbsResult = blurbsService.addBlurb(blurbs);
        if (blurbsResult.isSuccess()) {
            return new ResponseEntity<>(blurbsResult, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(blurbsResult, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/blurbs/update/{blurbsId}")
    public ResponseEntity<Result<Blurbs>> updateBlurb(@AuthenticationPrincipal AppUser appUser, @RequestBody Blurbs blurbs, @PathVariable int blurbsId) {
        blurbs.setAppUserId(appUser.getAppUserId());

        Result<Blurbs> blurbsResult = blurbsService.updateBlurbs(blurbs);
        if (blurbsResult.isSuccess()) {
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(blurbsResult, HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/blurbs/delete/{blurbsId}")
    public ResponseEntity<Result<Void>> deleteBlurbById(@AuthenticationPrincipal AppUser appUser, @PathVariable int blurbsId, Blurbs blurbs) {
        blurbs.setAppUserId(appUser.getAppUserId());

        Result<Void> blurbsResult = blurbsService.deleteBlurbById(blurbsId);
        if (blurbsResult.isSuccess()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        if (!blurbsResult.isSuccess()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blurbsResult, HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/blurbs/list")
    public List<Blurbs> findAllBlurbs(@AuthenticationPrincipal AppUser appUser, int appUserId, Blurbs blurbs) {
        blurbs.setAppUserId(appUser.getAppUserId());

        return blurbsService.findAllBlurbs(appUserId);
    }


    @GetMapping("/blurbs/detail/{blurbsId}")
    public ResponseEntity<Blurbs> findBlurbById(@AuthenticationPrincipal AppUser appUser, Blurbs blurbs, @PathVariable int blurbsId) {
        blurbs.setAppUserId(appUser.getAppUserId());

        Blurbs specificBlurb = blurbsService.findBlurbById(blurbsId);
        if (specificBlurb == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(specificBlurb, HttpStatus.OK);
    }


}
