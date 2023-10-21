package crystals.Domain;

import crystals.Models.Blurbs;
import crystals.Data.BlurbsRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class BlurbsServiceTest {

    @MockBean
    BlurbsRepository blurbsRepository;

    @Autowired
    BlurbsService blurbsService;

    @Test
    void shouldNotAllowNullTitle() {
        Blurbs blurb = TestHelper.makeBlurb();
        blurb.setTitle(null);

        Result<Blurbs> result = blurbsService.addBlurb(blurb);

        assertFalse(result.isSuccess());
    } // cant invoke string.length blah blah blah

    @Test
    void shouldNotAllowOverMaxCharTitle() {
        StringBuilder longTitle = new StringBuilder();
        for (int i = 0; i < 251; i++) {
            longTitle.append("a");
        }

        Blurbs blurb = TestHelper.makeBlurb();
        blurb.setTitle(longTitle.toString());

        Result<Blurbs> result = blurbsService.addBlurb(blurb);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotAllowNullTextBody() {
        Blurbs blurb = TestHelper.makeBlurb();
        blurb.setTextBody(null);

        Result<Blurbs> result = blurbsService.addBlurb(blurb);

        assertFalse(result.isSuccess());
    } // same string.length issue as all other null tests


    @Test
    void shouldNotAllowOverMaxCharTextBody() {
        Blurbs blurb = TestHelper.makeBlurb();

        StringBuilder longTextBody = new StringBuilder();
        for (int i = 0; i < 2050; i++) {
            longTextBody.append("a");
        }
        blurb.setTextBody(longTextBody.toString());

        Result<Blurbs> result = blurbsService.addBlurb(blurb);

        assertFalse(result.isSuccess());
    }


    @Test
    void shouldNotAllowOverMaxCharImgUrl() {
        Blurbs blurb = TestHelper.makeBlurb();

        StringBuilder longImgUrl = new StringBuilder();
        for (int i = 0; i < 505; i++) {
            longImgUrl.append("a");
        }
        blurb.setImageUrl(longImgUrl.toString());

        Result<Blurbs> result = blurbsService.addBlurb(blurb);

        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAllowMissingAppUser() {

        Blurbs blurb = TestHelper.makeBlurb();
        blurb.setAppUserId(0);

        Result<Blurbs> result = blurbsService.addBlurb(blurb);

        assertFalse(result.isSuccess());
    }






} // last one don't delete
