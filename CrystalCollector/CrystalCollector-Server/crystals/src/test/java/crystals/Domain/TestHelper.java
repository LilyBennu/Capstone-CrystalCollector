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
        Crystal testCrystal = new Crystal();

        testCrystal.setCrystalId(1);
        testCrystal.setCrystalName("TestCrystalName");
        testCrystal.setColor("TestColor");
        testCrystal.setAmountOwned(10);
        testCrystal.setShape("TestShape");
        testCrystal.setNotes("TestNotes words words words");
        testCrystal.setRaw(true);
        testCrystal.setInCollection(true);
        testCrystal.setImageUrl("test.com/exampleUrl");
        testCrystal.setCrystalSpecification(CrystalSpecification.REGULAR);
        testCrystal.setAppUserId(1);
        return testCrystal;
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
