package crystals.Models;

import java.util.Objects;

public class AppUser {

    private int appUserId;
    private String appUserName;
    private String passwordHash;
    private boolean enabled;


    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId && enabled == appUser.enabled && Objects.equals(appUserName, appUser.appUserName) && Objects.equals(passwordHash, appUser.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, appUserName, passwordHash, enabled);
    }
}
