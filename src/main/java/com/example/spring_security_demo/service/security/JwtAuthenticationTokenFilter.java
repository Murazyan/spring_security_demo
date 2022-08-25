package com.example.spring_security_demo.service.security;

import com.example.spring_security_demo.model.User;
import com.example.spring_security_demo.repository.UserRepository;
import com.example.spring_security_demo.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Qualifier("currentUserDetailServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        response.setHeader("Access-Control-Allow-Origin", "Authorization");
//        response.setHeader("Access-Control-Allow-Headers", "Authorization");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
//        response.setHeader("Access-Control-Allow-Origin","*");
//        final String requestHeader = request.getHeader(this.tokenHeader);
//        String currentUserUsername = null;
//        String authToken = null;
//        User currentUser = null;
//        if (requestHeader != null && requestHeader.startsWith("*LilMag* ")) {
//            authToken = requestHeader.substring(9);
//            try {
//                 jwtTokenUtil.getUsernameFromToken(authToken);
//            }catch (Exception e){
//                response.sendError(401);
//                return;
//            }
//            UUID id = (UUID) jwtTokenUtil.getAllClaimsFromToken(authToken).get("id");
//            currentUser = userRepository.findById(id).get();
//            if (currentUser == null) {//երբ տվյալ օգտատերը արդեն ամբողջությամբ ջնջվել է մեր համակարգից՝ ջնջվել է ՏԲ-ից։
////                response.setStatus(102, "Դուք ջնջվել եք մեր համակարգից, խնդրում ենք նորից գրանցվել");
//                response.sendError(410,"Դուք ջնջվել եք մեր համակարգից, խնդրում ենք նորից գրանցվել");
//                return;
//            } else {
//                try {
//                    currentUserUsername = jwtTokenUtil.getUsernameFromToken(authToken);
//                    String tokenPass = (String) jwtTokenUtil.getAllClaimsFromToken(authToken).get("password");
//                    if (!currentUserUsername.equals(currentUser.getEmail()) || !currentUser.getPassword().equals(tokenPass)) {
//                        response.sendError(403, "Փոփոխվել է էլ հասցե կամ գաղտնաբառ");
//                        return;
//                    }
//                } catch (ExpiredJwtException e) {
////                // սա աշխատում է այն ժամանակ երբ թոկենի ժամանակը լրացել է, այսինքն թոկենը էլ ակտիվ չէ
//                } catch (Exception e) {
//                    logger.error(e);
//                }
//            }
//        } else {
////            logger.warn("couldn't find *LilMag* string, will ignore the header");
//        }
//        if (currentUser != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            String usernamelowercase = currentUser.getUsername().toLowerCase();
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(usernamelowercase);
//            int tokenId = (int) jwtTokenUtil.getAllClaimsFromToken(authToken).get("id");
//            if (currentUserUsername != null && jwtTokenUtil.validateToken(authToken, userDetails.getUsername()) &&
//                    userDetails.getPassword().equals(jwtTokenUtil.getAllClaimsFromToken(authToken).get("password")) &&
//                    currentUser.getId() == tokenId && currentUser.getUsername().equals(currentUserUsername)) {
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        chain.doFilter(request, response);
    }
}