package artistep.version1.global.security;

import artistep.version1.global.exception.CustomException;
import artistep.version1.global.exception.ErrorCode;
import artistep.version1.v1domain.majorUser.user.User;
import artistep.version1.v1domain.majorUser.user.kdhRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 서비스 구분을 위함 (구글 : google, 네이버 : naver)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // OAuth 2 정보를 반환하기 위함
        String userNameAttribute = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        Map<String, Object> response = oAuth2User.getAttributes();

        String email = (String) response.get("email");

        Optional<User> optionalUser = userRepository.findByEmail(email);

        // 동일한 이메일이 있으면 로그인하면 됨 <-> 아니면 유저 생성 후 DB에 저장
        if (userRepository.findByEmail(email).isPresent()) {
            User user = optionalUser.get();

            return new DefaultOAuth2User(Collections.singleton(
                    new SimpleGrantedAuthority(user.getStatus())),
                    oAuth2User.getAttributes(),
                    userNameAttribute);

        } else if (optionalUser.isEmpty()) {
            User user = User.builder()
                    .email(email)
                    .status("일반")
                    .build();
            userRepository.save(user);

            return new DefaultOAuth2User(Collections.singleton(
                    new SimpleGrantedAuthority(user.getStatus())),
                    oAuth2User.getAttributes(),
                    userNameAttribute);
        }
        throw new CustomException(ErrorCode.INVALID_REQUEST);
    }
}