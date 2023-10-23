package crystals.Security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@ConditionalOnWebApplication
public class SecurityConfig {

//     SecurityFilterChain allows configuring
//     web based security for specific http requests.

    private final JwtConverter jwtConverter;

    public SecurityConfig(JwtConverter converter) {
        this.jwtConverter = converter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // we're not using HTML forms in our app
        //so disable CSRF (Cross Site Request Forgery) SHOULD THIS BE ENABLED?
        http.csrf().disable();

        // this configures Spring Security to allow
        //CORS related requests (such as preflight checks)
        http.cors();

        // the order of the antMatchers() method calls is important
        // as they're evaluated in the order that they're added

        // change these for my paths, i think change everything to authorize/ permitAll
        // naw some or maybe even all of them need to be authority(USER)
        // also what order should these go in??? do GETS - POSTS - PUT - DELETE
        http.authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/refresh_token").authenticated() // token refresh
                .antMatchers(HttpMethod.GET, "/order").permitAll()
                .antMatchers(HttpMethod.GET, "/sighting", "/sighting/*").permitAll()
                .antMatchers(HttpMethod.POST, "/sighting").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/sighting/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/sighting/*").hasAnyAuthority("ADMIN")
                // if we get to this point, let's deny all requests
                .antMatchers("/**").denyAll()
                .and()
                .addFilter(new JwtRequestFilter(authenticationManager(authenticationConfiguration), jwtConverter))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
