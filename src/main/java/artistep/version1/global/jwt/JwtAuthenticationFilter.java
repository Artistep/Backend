package artistep.version1.global.jwt;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String[] whitelist = {"/", "/user/detail-join", "/user/login"};
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final JwtUtillizer jwtUtillizer;

    private Authentication getAuthentication(HttpServletRequest request) {

        // 요청헤더인 Authorization 으로 부터 토큰을 가져온다.
        String token = request.getHeader(AUTHORIZATION_HEADER);
        Claims claims = jwtUtillizer.jwtResolve(token.substring("Bearer ".length()));

        //스프링 내부에서 사용하는 Authentication
        return new UsernamePasswordAuthenticationToken(claims, null);
    }

    // URL 검증 -> /, /user/detail-join, /user/login 일 시 false
    private boolean checkIsNotWhitelist(String requestURL) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURL);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        if (checkIsNotWhitelist(request.getRequestURI())) {

            // 요청헤더인 Authorization 으로 부터 토큰을 가져온다.
            String token = request.getHeader("Authorization").substring("Bearer ".length());

            jwtUtillizer.validateToken(token);

            // 토큰 검증 후 true 면 Security Context 에 인증 정보 담기
            getAuthentication(request);
            Authentication authentication = getAuthentication(request);
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
