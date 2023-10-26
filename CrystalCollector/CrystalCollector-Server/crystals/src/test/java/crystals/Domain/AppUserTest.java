package crystals.Domain;

import crystals.Data.AppUserRepository;
import crystals.Models.AppUser;
import crystals.Domain.AppUserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
@SpringBootTest
public class AppUserTest {

    @MockBean
    AppUserRepository appUserRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Autowired
    AppUserService appUserService;
}
