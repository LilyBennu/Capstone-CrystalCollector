package crystals.Domain;

import crystals.Data.AppUserRepository;
import crystals.Models.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    private final PasswordEncoder passwordEncoder;


    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public UserDetails loadUserByUsername(String appUserName) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUsername(appUserName);
        // Find a matching user
        if (appUser == null || !appUser.isEnabled()) {
            throw new UsernameNotFoundException(String.format("%s not found.", appUserName));
        }

        return appUser;
    }

    public Result<AppUser> addAppUser(String appUserName, String password) {
        Result<AppUser> result = validate(appUserName, password);
        if (!result.isSuccess()) {
            return result;
        }

        password = passwordEncoder.encode(password);

        AppUser appUser = new AppUser(0, appUserName, password, true, List.of("USER"));

        result.setPayload(appUserRepository.addAppUser(appUser));

        return result;
    }

    private Result<AppUser> validate(String appUserName, String password) {
        Result<AppUser> result = new Result<>();

        if (appUserName == null || appUserName.isBlank()) {
            result.addMessage("username is required", ResultType.INVALID);
        }

        if (password == null || password.isBlank()) {
            result.addMessage("password is required", ResultType.INVALID);
        }

        if (!result.isSuccess()) {
            return result;
        }

        if (appUserName.length() > 50) {
            result.addMessage("username must be 50 characters max", ResultType.INVALID);
        }

        if (!validatePassword(password)) {
            result.addMessage("password must be at least 8 character and contain a digit, a letter, and a non-digit/non-letter", ResultType.INVALID);
        }

        if (!result.isSuccess()) {
            return result;
        }

        try {
            if (loadUserByUsername(appUserName) != null) {
                result.addMessage("the provided username already exists", ResultType.INVALID);
            }
        } catch (UsernameNotFoundException e) {
            // good!
        }

        return result;
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        int digits = 0;
        int letters = 0;
        int others = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isLetter(c)) {
                letters++;
            } else {
                others++;
            }
        }

        return digits > 0 && letters > 0 && others > 0;
    }


}
