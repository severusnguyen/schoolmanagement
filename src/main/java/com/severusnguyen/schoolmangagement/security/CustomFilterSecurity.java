package com.severusnguyen.schoolmangagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class CustomFilterSecurity {
    //https://www.javaguides.net/p/spring-security-tutorial.html
    //https://stackoverflow.com/questions/77266685/spring-security-6-cors-is-deprecated-and-marked-for-removal

    @Autowired   // Dùng CustomStudentDetailService để thay thế vào UserDetail mặc định implements từ UserDetailsService
    CustomStudentDetailService customStudentDetailService; //Để tạo chứng thực động .

    @Autowired
    CustomJwtFilter customJwtFilter;

    //https://www.javaguides.net/2021/10/spring-boot-login-rest-api.html
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);  // Không nên new AuthenticationManagerBuilder(); vì khi new sẽ không sử dụng AuthenticationManager mặc định nên dùng tham số HttpSecurity
        authenticationManagerBuilder.userDetailsService(customStudentDetailService).passwordEncoder(passwordEncoder());

        return authenticationManagerBuilder.build();
    }

    //58
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {    //1
//        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
//                .authorizeHttpRequests((requests) -> requests
//                        //.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards", "/user").authenticated()
//                        .requestMatchers("/login/**").permitAll() //, "/menu/file/**", "/student/file/**", "/student/**"
//                        .anyRequest()
//                        .authenticated()
//
//                );


        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
            //Đây là nơi định nghĩa link nào được phép và ngược lại

         http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                 .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  //Khong sử dụng session trong Spring Security tại đang dùng JWT
                //.and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login/**", "/grade/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                );

                //.httpBasic(Customizer.withDefaults()) //DÙng JWT nên bỏ Basic Authen
                //.build();


        http.addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class); //Chạy trước khi filter đăng nhập (chứng thực) chạy  62 - 4

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //Make the below setting as * to allow connection from any hos
        corsConfiguration.setAllowedOrigins(List.of("http://127.0.0.1:5500/"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //2
}
