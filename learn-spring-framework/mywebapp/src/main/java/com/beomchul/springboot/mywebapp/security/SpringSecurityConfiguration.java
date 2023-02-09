//package com.beomchul.springboot.mywebapp.security;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.function.Function;
//
////@Configuration
//public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public InMemoryUserDetailsManager createUserDetailsManager(){
//
//        UserDetails userDetails1 = createNewUser("beomchul", "aaa");
//        UserDetails userDetails2 = createNewUser("ranga", "aaa");
//
//        //InMemoryUserDetailsManager는 가변 인자(매개변수 동적)사용
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//    }
//
//    private UserDetails createNewUser(String username, String password) {
//        Function<String, String> passwordEncoder
//                = input -> passwordEncoder().encode(input);
//
//        UserDetails userDetails = User.builder()
//                .passwordEncoder(passwordEncoder)
//                .username(username)
//                .password(password)
//                .roles("USER", "ADMIN")
//                .build();
//        return userDetails;
//    }
//
//    //인코딩 기법
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .httpBasic().disable()
//                .cors()//.configurationSource(corsConfigurationSource())
//                .and()
//                .authorizeRequests(
//                        auth -> auth.anyRequest().permitAll()
//                );
//        http.formLogin(withDefaults());
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//
//        //config.setAllowCredentials(true);
//        config.setAllowedOrigins(Arrays.asList("*"));
//        config.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE","PUT"));
//        config.setAllowedHeaders(Arrays.asList("*"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//}
