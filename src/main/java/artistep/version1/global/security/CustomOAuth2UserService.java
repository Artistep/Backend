//package artistep.version1.global.security;
//
//import artistep.version1.global.exception.CustomException;
//import artistep.version1.global.exception.ErrorCode;
//import artistep.version1.v1domain.majorUser.user.User;
//import artistep.version1.v1domain.majorUser.user.kdhRepository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpSession;
//import java.util.Collections;
//import java.util.Map;
//import java.util.Set;
//
//
//@RequiredArgsConstructor
//@Service
//@Transactional
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//        ClientRegistration.ProviderDetails.UserInfoEndpoint userInfoEndpoint = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint();
//
//        String userInfoUri = userInfoEndpoint.getUri();
//        validateUserInfoUri(userRequest, userInfoUri);
//
//        String nameAttributeKey = userInfoEndpoint.getUserNameAttributeName();
//        validateUserNameAttributeName(userRequest, nameAttributeKey);
//
//        Map<String, Object> attributes = getAttributes(userRequest);
//        Set<GrantedAuthority> authorities = getAuthorities(userRequest, attributes);
//
//        return KakaoOAuth2User.builder()
//                .authorities(authorities)
//                .attributes(attributes)
//                .nameAttributeKey(nameAttributeKey)
//                .build();
//    }
//
//    /* ... */
//}