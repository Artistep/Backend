package artistep.version1.global.oauth;


import artistep.version1.global.jwt.JwtUtilizer;
import artistep.version1.v1domain.majorUser.user.Status;
import artistep.version1.v1domain.majorUser.user.User;
import artistep.version1.v1domain.majorUser.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final JwtUtilizer jwtUtilizer;
    private final RedirectStrategy redirectStrategy;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        // 최초 OAuth 요청이라면 회원가입 처리를 한다.
        if (userRepository.findByEmail(oAuth2User.getAttribute("email")).isEmpty()) {
            User needToJoin = User.builder()
                    .email(oAuth2User.getAttribute("email"))
                    .picture(oAuth2User.getAttribute("picture"))
                    .status(Status.ROLE_USER)
                    .build();
            userRepository.save(needToJoin);
        }

        // 최초 OAuth 요청이 아니라면
        else if (userRepository.findByEmail(oAuth2User.getAttribute("email")).isPresent()) {

            User needToLogin = userRepository.findByEmail(oAuth2User.getAttribute("email")).get();

            String accessToken = jwtUtilizer.createAccessToken(needToLogin);
            String refreshToken = jwtUtilizer.createRefreshToken(needToLogin);

            String targetUrl = UriComponentsBuilder.fromUriString("/user/login")
                    .queryParam("AccessToken", accessToken)
                    .queryParam("RefreshToken", refreshToken)
                    .build().toUriString();

            redirectStrategy.sendRedirect(request, response, targetUrl);
        }
    }
}
