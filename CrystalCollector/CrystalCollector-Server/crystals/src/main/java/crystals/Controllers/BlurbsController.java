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

    //POST PUT DELETE GET

    //    addBlurb(crystals.Models.Blurbs blurbs);
    //    updateBlurb(crystals.Models.Blurbs blurbs);
    //    deleteBlurbById(int blurbId);
    //    List<Blurbs>findAllBlurbs(int appUserId);
    //    findBlurbById(int blurbId);


}
