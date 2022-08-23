package artistep.version1.global.security;


import artistep.version1.global.jwt.JwtAuthenticationFilter;
import artistep.version1.global.oauth.CustomOAuth2UserService;
import artistep.version1.global.oauth.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


/**
 < userInfoEndpoint >
 OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당합니다.


 < userService >

 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록합니다.
 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있습니다.

 */


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] whitelist = {"/", "/user/detail-join", "/user/my-page"};

    private final CustomOAuth2UserService customOAuth2UserService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers("/user/login").authenticated()
                    .antMatchers(whitelist).permitAll()
                .and()
                    .oauth2Login()
                    .successHandler(oAuth2SuccessHandler)
                    .userInfoEndpoint().userService(customOAuth2UserService);
    }

//    private SecurityExpressionHandler<FilterInvocation> configExpressionHandler() {
//    }
//
//    private CustomAuthenticationEntryPoint configAuthenticationEntryPoint() {
//    }
//
//    private CustomAccessDeniedHandler configAccessDeniedHandler() {
//    }
//
//    private CustomAuthenticationSuccessHandler configSuccessHandler() {
//    }
//
//    private CustomAuthenticationFailureHandler configFailureHandler() {
//    }

}