package crystals.Controllers;

import crystals.Domain.CrystalService;
import crystals.Domain.Result;
import crystals.Domain.ResultType;
import crystals.Models.Crystal;
import crystals.Models.AppUser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/crystals")
public class CrystalController {

    private final CrystalService crystalService;


    public CrystalController(CrystalService crystalService) {
        this.crystalService = crystalService;
    }


    @PostMapping("/add")
    public ResponseEntity<Result<Crystal>> addCrystal(@AuthenticationPrincipal AppUser appUser, @RequestBody Crystal crystal) {
        // connect everything to AppUserId
        crystal.setAppUserId(appUser.getAppUserId());

        Result<Crystal> crystalResult = crystalService.addCrystal(crystal);
        if (crystalResult.isSuccess()) {
            return new ResponseEntity<>(crystalResult, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(crystalResult, HttpStatus.BAD_REQUEST);
    }

        // should i specify these paths or is that gonna make the hackers
        // get me more easily?????
    @PutMapping("/update/{crystalId}")
    public ResponseEntity<Result<Crystal>> updateCrystal(@AuthenticationPrincipal AppUser appUser, @PathVariable int crystalId, @RequestBody Crystal crystal) {
        crystal.setAppUserId(appUser.getAppUserId());

        Result<Crystal> crystalResult = crystalService.updateCrystal(crystal);
        if (crystalResult.isSuccess()) {
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(crystalResult, HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/remove/{crystalId}")
    public ResponseEntity<Result<Void>> removeCrystalById(@AuthenticationPrincipal AppUser appUser, @PathVariable int crystalId, Crystal crystal) {
        crystal.setAppUserId(appUser.getAppUserId());

        Result<Void> crystalResult = crystalService.removeCrystalById(crystalId);
        if (crystalResult.isSuccess()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        if (!crystalResult.isSuccess()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(crystalResult, HttpStatus.BAD_REQUEST);
    }
    

    @GetMapping("/list")
    public List<Crystal> viewAllCrystals(@AuthenticationPrincipal AppUser appUser, int appUserId, Crystal crystal) {
        crystal.setAppUserId(appUser.getAppUserId());
        return crystalService.viewAllCrystals(appUserId);
    }


    @GetMapping("/detail/{crystalId}")
    public ResponseEntity<Crystal> findCrystalById(@AuthenticationPrincipal AppUser appUser, @PathVariable int crystalId, Crystal crystal) {
        crystal.setAppUserId(appUser.getAppUserId());

        Crystal specificCrystal = crystalService.findCrystalById(crystalId);
        if (specificCrystal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(specificCrystal, HttpStatus.OK);
    }

}
