package artistep.version1.global.oauth;


import artistep.version1.global.jwt.JwtUtillizer;
import artistep.version1.v1domain.majorUser.user.Status;
import artistep.version1.v1domain.majorUser.user.User;
import artistep.version1.v1domain.majorUser.user.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static artistep.version1.v1domain.majorUser.user.QUser.user;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JPAQueryFactory queryFactory;
    private final UserRepository userRepository;


    // 지원이형공유 -> queryDSL INsert
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();


        if (userRepository.findByEmail(oAuth2User.getAttribute("email")).isEmpty()) {
            String email = oAuth2User.getAttribute("email");
            // 최초 로그인이라면 회원가입 처리를 한다.
            User user = new User();

            user.setEmail(email);
            user.setStatus(Status.USER);

            userRepository.save(user);
        }

        System.out.println("Redirect 실행 전");
        response.sendRedirect("/");
        System.out.println("Redirect 실행 완료");
    }
}
