package artistep.version1.global.jwt;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtillizer jwtUtillizer;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 요청헤더인 Authorization 으로 부터 토큰을 가져온다.
        String token = request.getHeader("Authorization");
        jwtUtillizer.validateToken(token);

        // Spring Security Context 에 담기위한 인증객체인 Authentication 을 생성한다.
        Authentication authentication = getAuthentication(request);

        if(authentication != null){
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private Authentication getAuthentication(HttpServletRequest request) {

        // 요청헤더인 Authorization 으로 부터 토큰을 가져온다.
        String token = request.getHeader("Authorization");
        jwtUtillizer.validateToken(token);

        Claims claims = jwtUtillizer.jwtResolve(token.substring("Bearer ".length()));

        //스프링 내부에서 사용하는 Authentication
        return new UsernamePasswordAuthenticationToken(claims, null);
    }
}
