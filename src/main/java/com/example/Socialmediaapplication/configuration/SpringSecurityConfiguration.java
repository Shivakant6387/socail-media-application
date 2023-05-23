package com.example.Socialmediaapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
//        @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        List<UserDetails> userDetails= Arrays.asList(
//                User.builder().username("user").password("{noop}kill").roles("USER").build(),
//                User.builder().username("manager").password("{noop}killed").roles("USER","MANAGER").build(),
//                User.builder().username("admin").password("{noop}killer").roles("USER","MANAGER","ADMIN").build()
//
//              );
//
//        InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager(userDetails);
//        return userDetailsManager;
//    }
    @Bean
    JdbcUserDetailsManager userDetailsManagers(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests(authorizeRequests->
                authorizeRequests
                        .requestMatchers(HttpMethod.GET,"/api/jpa/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,"/api/jpa/users/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/api/jpa/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/jpa/users/**").hasRole("ADMIN")

        );
               httpSecurity .httpBasic();
                httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
