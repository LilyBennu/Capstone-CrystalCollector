package crystals.Domain;
// 2:25 pm
import crystals.Data.CrystalRepository;
import crystals.Models.Crystal;
import crystals.Models.CrystalSpecification;
import crystals.Models.AppUser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import crystals.Domain.TestHelper.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrystalServiceTest {

    @MockBean
    CrystalRepository crystalRepository;

    @Autowired
    CrystalService crystalService;






    @Test
    void shouldntAllowNullCrystalNam() {

    }
//    - shouldntAllowCrystalNameOverMaxChars
//    - shouldntAllowNullColor
//    - shouldntAllowColorOverMaxChars
//    - shouldntAllowEmptyAmountOwned
//    - shouldAllowZeroAmountOwned
//    - shouldntAllowNullShape
//    - shouldntAllowShapeOverMaxChars
//    - shouldAllowNullNotes
//    - shouldntAllowNotesOverMaxChars
//    - shouldAllowNullImgUrl
//    - shouldntAllowImgUrlOverMaxChars
//    - shouldntAllowNullCrystalSpecType
//    - shouldBeTiedToUser



    @Test
    void shouldNotAddNullCrystal() {

        Crystal crystal = null;
        Result result = crystalService.addCrystal(crystal);

        assertFalse(result.isSuccess());
    } // dumb test proving my point but not passing lol


} // last one don't delete
