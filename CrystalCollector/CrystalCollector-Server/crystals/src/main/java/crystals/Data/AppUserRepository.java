package crystals.Data;

public interface AppUserRepository {
    crystals.Models.AppUser findByUsername(String username);

    crystals.Models.AppUser findByAppUserId(int appUserId);

    crystals.Models.AppUser addAppUser(crystals.Models.AppUser appUser);
}
