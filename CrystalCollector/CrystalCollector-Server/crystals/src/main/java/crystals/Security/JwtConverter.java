package crystals.Security;

import crystals.Models.AppUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// go through this class and take out what's not need for project

@Component
public class JwtConverter {

    // 1. Signing key
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 2. "Configurable" constants
    private final String ISSUER = "crystals-api";
    private final int EXPIRATION_MINUTES = 15;
    private final int EXPIRATION_MILLIS = EXPIRATION_MINUTES * 60 * 1000;

    public String getTokenFromUser(AppUser appUser) {

        List<String> authorities = appUser.getAuthorities().stream()
                .map(r -> r.getAuthority()).toList();

        return Jwts.builder()
                .setIssuer(ISSUER)
                .setSubject(appUser.getAppUserName())
                // new... embed the `appUserId` in the JWT as a claim
                .claim("app_user_id", appUser.getAppUserId())
                .claim("authorities", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key)
                .compact();
    }

    // Return an instance of `AppUser`
    public AppUser getUserFromToken(String token) {

        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .requireIssuer(ISSUER)
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.substring(7));

            String appUserName = jws.getBody().getSubject();
            // this is the bg version, which was a bit different than lesson version
            int appUserId = jws.getBody().get("app_user_id", Integer.class);
            List<String> authorities = jws.getBody().get("authorities", List.class);


            // this is angry, expecting 0 arguments but found 5
            return new AppUser(appUserId, appUserName, null, true, authorities);

        } catch (JwtException e) {
            System.out.println(e);
        }

        return null;
    }
}
