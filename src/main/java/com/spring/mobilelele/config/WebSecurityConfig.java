package com.spring.mobilelele.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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

            String loginPage = "/authentication/login";
            String logoutPage = "/logout";

            http.
                    authorizeRequests()
                    .antMatchers("/static/**", "/css/**", "/img/**","/js/**").permitAll()
                    .antMatchers("/authentication/**").anonymous()
                    .antMatchers("/home").authenticated()
                    .antMatchers("/").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and().csrf().disable()
                    .formLogin()
                    .loginPage(loginPage)
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/home")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
                    .logoutSuccessUrl(loginPage).and().exceptionHandling();
        }
    }
