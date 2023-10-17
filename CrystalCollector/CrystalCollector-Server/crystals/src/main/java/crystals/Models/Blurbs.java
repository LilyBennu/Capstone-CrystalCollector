package crystals.Models;

import java.util.Objects;

public class Blurbs {

    private int blurbsId;
    private int appUserId;
    private String title;
    private String textBody;
    private String imageUrl;

    // may need to add a field for user image uploads


    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public int getBlurbsId() {
        return blurbsId;
    }

    public void setBlurbsId(int blurbsId) {
        this.blurbsId = blurbsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blurbs blurbs = (Blurbs) o;
        return blurbsId == blurbs.blurbsId && appUserId == blurbs.appUserId && Objects.equals(title, blurbs.title) && Objects.equals(textBody, blurbs.textBody) && Objects.equals(imageUrl, blurbs.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blurbsId, appUserId, title, textBody, imageUrl);
    }
}
