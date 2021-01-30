package com.spring.mobilelele.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.spring.mobilelele.common.GlobalConstants.*;

    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//        private final BCryptPasswordEncoder bCryptPasswordEncoder;
//        private final UserDetailsService userDetailsService;
//
//
//        @Autowired
//        public WebSecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationService authenticationService) {
//            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//            this.userDetailsService = authenticationService;
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth
//                    .userDetailsService(userDetailsService)
//                    .passwordEncoder(bCryptPasswordEncoder);
//        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {


            http.
                    authorizeRequests()
                    .antMatchers("/static/**", "/css/**", "/img/**","/js/**").permitAll()
                    .antMatchers(LOGIN_URL,REGISTER_URL).anonymous()
                    .antMatchers("/home").authenticated()
                    .antMatchers("/").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and().csrf().disable()
                    .formLogin()
                    .loginPage(LOGIN_URL)
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/home")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_URL))
                    .logoutSuccessUrl(LOGIN_URL).and().exceptionHandling();
        }
    }
