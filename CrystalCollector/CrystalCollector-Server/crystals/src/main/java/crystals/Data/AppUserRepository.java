package crystals.Data;

import crystals.Models.AppUser;

import java.util.List;

public interface AppUserRepository {
    AppUser findByUsername(String username);

    AppUser findByAppUserId(int appUserId, String appUserName);

    AppUser addAppUser(AppUser appUser);


}
