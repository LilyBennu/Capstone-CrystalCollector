package crystals.Security;


import crystals.Models.AppUser;
import io.jsonwebtoken.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//    public class JwtRequestFilter extends BasicAuthenticationFilter {
//
//        // snip!
//
//        @Override
//        protected void doFilterInternal(HttpServletRequest request,
//                                        HttpServletResponse response,
//                                        FilterChain chain) throws IOException, ServletException {
//
//            String authorization = request.getHeader("Authorization");
//            if (authorization != null && authorization.startsWith("Bearer ")) {
//
//                // new... get our `AppUser` from the converter
//                AppUser user = converter.getUserFromToken(authorization);
//                if (user == null) {
//                    response.setStatus(403); // Forbidden
//                } else {
//
//                    // Update the "principal" from the username to `user`
//                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
//                            AppUser, null, user.getAuthorities());
//
//                    SecurityContextHolder.getContext().setAuthentication(token);
//                }
//            }
//
//            chain.doFilter(request, response);
//        }
//    }

