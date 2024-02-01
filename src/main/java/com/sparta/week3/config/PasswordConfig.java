package com.sparta.week3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 빈 등록 메소드가 속해 있는 클래스 위에 작성
public class PasswordConfig {

    @Bean // 빈등록
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // PasswordEncoder에 들어가보면 인터페이스로 구현체를 넣어줘야 함
        // 비밀번호를 암호화 해주는 해시 함수 : BCrypt
    }
}