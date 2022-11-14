package com.management.cgmanagement.configuration;

import com.management.cgmanagement.configuration.custom.JwtAuthenticationFilter;
import com.management.cgmanagement.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    IUserService accountService;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .and()

                .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/student/**").hasRole("STUDENT").and()
                .authorizeRequests().antMatchers("/class/**").hasRole("TEACHER")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.csrf().disable();
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling();
        http.cors().configurationSource(c -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.applyPermitDefaultValues();
            configuration.addAllowedOriginPattern("*");
            configuration.addAllowedMethod(HttpMethod.DELETE);
            configuration.addAllowedMethod(HttpMethod.GET);
            configuration.addAllowedMethod(HttpMethod.POST);
            configuration.addAllowedMethod(HttpMethod.PUT);
            configuration.addAllowedMethod(HttpMethod.HEAD);
            return configuration;
        });
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}