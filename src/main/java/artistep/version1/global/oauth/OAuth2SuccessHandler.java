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
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final JwtUtillizer jwtUtillizer;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();

        // 최초 OAuth 요청이라면 회원가입 처리를 한다.
        if (userRepository.findByEmail(oAuth2User.getAttribute("email")).isEmpty()) {
            String email = oAuth2User.getAttribute("email");
            User userNeedToJoin = new User();

            userNeedToJoin.setEmail(email);
            userNeedToJoin.setStatus(Status.USER);

            userRepository.save(userNeedToJoin);
        }

        // 최초 OAuth 요청이 아니라면, 로그인 처리를 한다. (토큰 발급)
        else if (userRepository.findByEmail(oAuth2User.getAttribute("email")).isPresent()) {
            Optional<User> loginUser = userRepository.findByEmail(oAuth2User.getAttribute("email"));

            System.out.println(returnToken(loginUser.get()));
        }
    }

    public String returnToken(User loginUser) {
        return jwtUtillizer.createAccessToken(loginUser);
    }
}
