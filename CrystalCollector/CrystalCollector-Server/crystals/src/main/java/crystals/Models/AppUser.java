package crystals.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUser implements UserDetails {

    private int appUserId;
    private String appUserName;
    private String passwordHash;
    private boolean enabled;

    private List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    public AppUser() {}

    public AppUser(int appUserId, String appUserName, String passwordHash, boolean enabled, List<String> authorities) {
        this.appUserId = appUserId;
        this.appUserName = appUserName;
        this.passwordHash = passwordHash;
        this.enabled = enabled;
        this.authorities = authorities.stream()
                .map(r -> new SimpleGrantedAuthority(r))
                .toList();
    }


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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    // TODO: consolidate password and username fields
    @Override
    public String getPassword() {
        return this.passwordHash;
    }

    @Override
    public String getUsername() {
        return this.appUserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.enabled;
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


    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", appUserName='" + appUserName + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", enabled=" + enabled +
                ", authorities=" + authorities +
                '}';
    }
}
