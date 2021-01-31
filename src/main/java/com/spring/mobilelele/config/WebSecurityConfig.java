package com.spring.mobilelele.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.spring.mobilelele.common.GlobalConstants.*;

    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private final BCryptPasswordEncoder bCryptPasswordEncoder;
        private final UserDetailsService userDetailsService;

        @Autowired
        public WebSecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder,
                                 @Qualifier("userLoginService") UserDetailsService userDetailsService) {
            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
            this.userDetailsService = userDetailsService;
        }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(bCryptPasswordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {


            http.
                    authorizeRequests()
                    .antMatchers("/static/**", "/css/**", "/img/**","/js/**").permitAll()
                    .antMatchers(LOGIN_PATH,LOGIN_ERROR_PATH,REGISTER_PATH).anonymous()
                    .antMatchers(INDEX_PATH).permitAll()
                    .anyRequest()
                    .authenticated()
                    .and().csrf().disable()
                    .formLogin()
                    .loginPage(LOGIN_PATH)
                    .failureUrl(LOGIN_ERROR_PATH)
                    .defaultSuccessUrl("/")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_PATH))
                    .logoutSuccessUrl(LOGIN_PATH).and().exceptionHandling();
        }
    }
