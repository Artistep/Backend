package artistep.version1.global.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll() // 그 이외에는 인증된 사용자만 접근 가능하게 합니다.
                .and()
                .oauth2Login() // oauth2Login 설정 시작
                .userInfoEndpoint() // oauth2Login 성공 이후의 설정을 시작
                .userService(customOAuth2UserService); // customOAuth2UserService 에서 처리하겠다.
    }
}