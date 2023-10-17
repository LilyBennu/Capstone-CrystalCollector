package crystals.Models;

import java.util.Objects;

public class Crystal {

    private String crystalName;
    private String color;
    private int amountOwned;
    private String shape;
    private String notes;
    private boolean raw;
    private boolean inCollection;
    private CrystalSpecification crystalSpecification;
    private String imageUrl;
    private int appUserId;
    private int crystalId;

    // may need to add a field for user image uploads


    public String getCrystalName() {
        return crystalName;
    }

    public void setCrystalName(String crystalName) {
        this.crystalName = crystalName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(int amountOwned) {
        this.amountOwned = amountOwned;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isRaw() {
        return raw;
    }

    public void setRaw(boolean raw) {
        this.raw = raw;
    }

    public boolean isInCollection() {
        return inCollection;
    }

    public void setInCollection(boolean inCollection) {
        this.inCollection = inCollection;
    }

    public CrystalSpecification getCrystalSpecification() {
        return crystalSpecification;
    }

    public void setCrystalSpecification(CrystalSpecification crystalSpecification) {
        this.crystalSpecification = crystalSpecification;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public int getCrystalId() {
        return crystalId;
    }

    public void setCrystalId(int crystalId) {
        this.crystalId = crystalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crystal crystal = (Crystal) o;
        return amountOwned == crystal.amountOwned && raw == crystal.raw && inCollection == crystal.inCollection && appUserId == crystal.appUserId && crystalId == crystal.crystalId && Objects.equals(crystalName, crystal.crystalName) && Objects.equals(color, crystal.color) && Objects.equals(shape, crystal.shape) && Objects.equals(notes, crystal.notes) && crystalSpecification == crystal.crystalSpecification && Objects.equals(imageUrl, crystal.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crystalName, color, amountOwned, shape, notes, raw, inCollection, crystalSpecification, imageUrl, appUserId, crystalId);
    }
}
