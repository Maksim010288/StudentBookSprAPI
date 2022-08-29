package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("maks").password("12345").roles("ADMIN")
                .and()
                .withUser("anton").password("12345").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").hasRole("ADMIN")
                .antMatchers("/students{id}").hasRole("ADMIN")
                .antMatchers("/books/{id}").hasRole("ADMIN")
                .antMatchers("/students/{studentId}/books").hasRole("ADMIN")
                .antMatchers("/students/{studentId}/books/{bookId}").hasRole("ADMIN")
                .antMatchers("/books/{id}").hasRole("ADMIN")
                .antMatchers("/books/getAll").hasRole("USER")
                .antMatchers("/students{id}").hasRole("USER")
                .antMatchers("/students/getAll").hasRole("USER")
                .and().httpBasic()
                .and().logout().logoutSuccessUrl("/");
    }


    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
