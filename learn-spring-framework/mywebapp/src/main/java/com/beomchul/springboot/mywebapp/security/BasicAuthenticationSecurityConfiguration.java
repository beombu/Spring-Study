//package com.beomchul.springboot.mywebapp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
//public class BasicAuthenticationSecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return  http
//                .authorizeRequests(
//                        auth -> auth
//                                //OPTIONS메소드에 대해서 인증x
//                                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                                .anyRequest().authenticated()//모든 요청에 인증 활성화
//                )
//                .httpBasic(Customizer.withDefaults())//기본 인증
//                .sessionManagement(//세션 생성
//                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .csrf().disable()//csrf 비활
//                .build();
//    }
//}
