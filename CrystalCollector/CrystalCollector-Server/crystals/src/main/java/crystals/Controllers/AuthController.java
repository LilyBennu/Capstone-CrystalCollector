package crystals.Controllers;

import crystals.Domain.AppUserService;
import crystals.Models.AppUser;
import crystals.Security.JwtConverter;
import crystals.Domain.Result;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



    @RestController
    @ConditionalOnWebApplication
    public class AuthController {

        private final AppUserService appUserService;

        private final AuthenticationManager authenticationManager;
        private final JwtConverter jwtConverter;

        public AuthController(AppUserService appUserService,
                              AuthenticationManager authenticationManager,
                              JwtConverter jwtConverter) {
            this.appUserService = appUserService;
            this.authenticationManager = authenticationManager;
            this.jwtConverter = jwtConverter;
        }

        @PostMapping("/crystals/sign-in")
        public ResponseEntity<?> signIn(@RequestBody Map<String, String> credentials) {
                            // is this username and password from sql?
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    credentials.get("username"), credentials.get("password"));

            // Moved AuthenticationException handling to the GlobalErrHandler
            Authentication authentication = authenticationManager.authenticate(authToken);
            if (authentication.isAuthenticated()) {
                AppUser appUser = (AppUser) authentication.getPrincipal();
                String jwt = jwtConverter.getTokenFromUser(appUser);
                Map<String, String> result = new HashMap<>();
                result.put("jwt_token", jwt);
                return ResponseEntity.ok(result);
            }

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        @PostMapping("/crystals/sign-up") // where this username n password from?
        public ResponseEntity<?> signUp(@RequestBody Map<String, String> credentials) {
            Result<AppUser> result = appUserService.addAppUser(
                    credentials.get("username"), credentials.get("password"));
            if (result.isSuccess()) {
                Map<String, Integer> appUserId = new HashMap<>();
                appUserId.put("app_user_id", result.getPayload().getAppUserId());
                return new ResponseEntity<>(appUserId, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        @PostMapping("/crystals/refresh-token")
        public ResponseEntity<Map<String, String>> refreshToken(@AuthenticationPrincipal AppUser appUser) {
            String jwt = jwtConverter.getTokenFromUser(appUser);
            Map<String, String> result = new HashMap<>();
            result.put("jwt_token", jwt);
            return ResponseEntity.ok(result);
        }

    }


