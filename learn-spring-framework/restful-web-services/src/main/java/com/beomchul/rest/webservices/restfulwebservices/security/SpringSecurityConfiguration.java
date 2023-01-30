package com.beomchul.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(//요청의 의한 보안검사 시작
                auth -> auth.anyRequest().authenticated()//어떤 요청에도 보안검사 시행
        );

        http.httpBasic(withDefaults());

        http.csrf().disable();//모든 요청에 랜덤으로 생성되는 scrf토큰을 비활성화 / http 파라미터로 생김 원래

        return http.build();
    }
}
