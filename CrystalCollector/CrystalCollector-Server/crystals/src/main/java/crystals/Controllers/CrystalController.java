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
    // POST PUT DELETE GET

    //    addCrystal(Crystal crystal);
    //    boolean updateCrystal(Crystal crystal);
    //    boolean removeCrystalById(int crystalId);
    //    List<Crystal> viewAllCrystals(int appUserId);
    //    findCrystalById(int crystalId);

}
