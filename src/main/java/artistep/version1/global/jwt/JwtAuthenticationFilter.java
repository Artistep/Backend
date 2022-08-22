package artistep.version1.global.jwt;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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


    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    private final JwtUtillizer jwtUtillizer;

    private Authentication getAuthentication(HttpServletRequest request) {

        // 요청헤더인 Authorization 으로 부터 토큰을 가져온다.
        String token = request.getHeader(AUTHORIZATION_HEADER);
        Claims claims = jwtUtillizer.jwtResolve(token.substring("Bearer ".length()));

        //스프링 내부에서 사용하는 Authentication
        return new UsernamePasswordAuthenticationToken(claims, null);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        // 요청헤더인 Authorization 으로 부터 토큰을 가져온다.
        String token = request.getHeader("Authorization");

        // 토큰 검증 후 true 면 Security Context 에 인증 정보 담기
        if (jwtUtillizer.validateToken(token)) {
            getAuthentication(request);
            Authentication authentication = getAuthentication(request);
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
