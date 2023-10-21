package crystals.Domain;

import crystals.Models.Crystal;
import crystals.Models.CrystalSpecification;
import crystals.Models.Blurbs;


public class TestHelper {



    public static Blurbs makeBlurb() {
        Blurbs blurb = new Blurbs();
        blurb.setTitle("Test Title");
        blurb.setTextBody("Test Text words words words");
        blurb.setImageUrl("example.com/testImgUrl");
        blurb.setAppUserId(5);
        blurb.setBlurbsId(0);
        return blurb;
    }

    public static Crystal makeCrystal() {
        Crystal crystal1 = new Crystal();

        crystal1.setCrystalId(1);
        crystal1.setCrystalName("TestCrystalName");
        crystal1.setColor("TestColor");
        crystal1.setAmountOwned(10);
        crystal1.setShape("TestShape");
        crystal1.setNotes("TestNotes words words words");
        crystal1.setRaw(true);
        crystal1.setInCollection(true);
        crystal1.setImageUrl("test.com/exampleUrl");
        crystal1.setCrystalSpecification(CrystalSpecification.REGULAR);
        crystal1.setAppUserId(1);
        return crystal1;
    }

    // make one for AppUser eventually



    public static <T> Result<T> makeResult(String message, ResultType type) {
        Result<T> result = new Result<>();
        if (message != null) {
            result.addMessage(message, type);
        }
        return result;
    }


}
