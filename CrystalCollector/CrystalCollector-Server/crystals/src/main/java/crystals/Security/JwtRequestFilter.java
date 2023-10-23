package crystals.Security;

import crystals.Security.JwtConverter;
import crystals.Models.AppUser;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class JwtRequestFilter extends BasicAuthenticationFilter {

        private final JwtConverter jwtConverter;
        public JwtRequestFilter(AuthenticationManager authenticationManager, JwtConverter jwtConverter) {
            super(authenticationManager);
            this.jwtConverter = jwtConverter;
        }

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain) throws IOException, ServletException {

            String authHeader = request.getHeader("Authorization");

            if (authHeader != null && authHeader.startsWith("Bearer ")) {

                // new... get our `AppUser` from the converter
                AppUser appUser = jwtConverter.getUserFromToken(authHeader);
                if (appUser == null) {
                    response.setStatus(403); // Forbidden
                } else {

                    // Update the "principal" from the username to `user`
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                            appUser, null, appUser.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }

            chain.doFilter(request, response);
        }
    }

