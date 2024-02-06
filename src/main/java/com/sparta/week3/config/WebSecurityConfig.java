package com.sparta.week3.config;

import com.sparta.week3.jwt.JwtAuthenticationFilter;
import com.sparta.week3.jwt.JwtAuthorizationFilter;
import com.sparta.week3.jwt.JwtUtil;
import com.sparta.week3.security.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@EnableGlobalMethodSecurity(securedEnabled = true) // @Secured 애너테이션 활성화
public class WebSecurityConfig {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationConfiguration authenticationConfiguration;

    public WebSecurityConfig(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService, AuthenticationConfiguration authenticationConfiguration) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(jwtUtil);
        filter.setAuthenticationManager(authenticationManager(authenticationConfiguration));
        return filter;
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter(jwtUtil, userDetailsService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF 설정
        http.csrf((csrf) -> csrf.disable());

        // 기본 설정인 Session 방식은 사용하지 않고 JWT 방식을 사용하기 위한 설정
        http.sessionManagement((sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // resources 접근 허용 설정
                        .requestMatchers("/api/user/**").permitAll() // '/api/user/'로 시작하는 요청 모두 접근 허가
                        .anyRequest().authenticated() // 그 외 모든 요청 인증처리
        );

        http.formLogin((formLogin) ->
                formLogin
                        .loginPage("/api/user/login-page").permitAll()
        );

        // 필터 관리
        http.addFilterBefore(jwtAuthorizationFilter(), JwtAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        // 접근 불가 페이지
        http.exceptionHandling((exceptionHandling) ->
                exceptionHandling
                        .accessDeniedPage("/forbidden.html")
        );

        return http.build();
    }
}

//filter에서 login 기능 처리할 수 있게 하기 위해 주석
//@Configuration
//@EnableWebSecurity // Spring Security 지원을 가능하게 함
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // CSRF 설정
//        http.csrf((csrf) -> csrf.disable());
//
//        http.authorizeHttpRequests((authorizeHttpRequests) ->
//                authorizeHttpRequests
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // resources 접근 허용 설정
//                        .requestMatchers("/api/user/**").permitAll() // '/api/user/'로 시작하는 요청 모두 접근 허가
//                        .anyRequest().authenticated() // 그 외 모든 요청 인증처리
//        );
//
//        // 로그인 사용
//        http.formLogin((formLogin) ->
//                formLogin
//                        // 로그인 View 제공 (GET /api/user/login-page)
//                        .loginPage("/api/user/login-page")
//                        // 로그인 처리 (POST /api/user/login)
//                        .loginProcessingUrl("/api/user/login")
//                        // 로그인 처리 후 성공 시 URL
//                        .defaultSuccessUrl("/")
//                        // 로그인 처리 후 실패 시 URL
//                        .failureUrl("/api/user/login-page?error")
//                        .permitAll()
//        );
//
//        return http.build();
//    }
//}