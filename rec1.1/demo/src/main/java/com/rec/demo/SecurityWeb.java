package com.rec.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityWeb {

    @Bean
    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
            @Override
            public void configure(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(requests -> requests
                        .antMatchers("/login.html").permitAll()
                        .antMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                        .formLogin(login -> login
                                .loginPage("/login.html")
                                .permitAll())
                        .logout(logout -> logout
                                .permitAll());
            }
        };
    }
}

// @Configuration
// @EnableWebSecurity
// public class SecurityWeb extends WebSecurityConfigurerAdapter {

// @Autowired
// private UserDetailsService userDetailsService;

// @Autowired
// public void configureGlobal(AuthenticationManagerBuilder auth) throws
// Exception {
// auth.userDetailsService(userDetailsService);
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }

// @Override
// protected void configure(AuthenticationManagerBuilder auth) throws Exception
// {
// auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
// }

// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http
// .authorizeRequests()
// .antMatchers("/admin/*").hasRole("ADMIN")
// .antMatchers("/css/*", "/js/*", "/img/*", "/**")
// .permitAll()
// .and().formLogin()
// .loginPage("/login")
// .loginProcessingUrl("/logincheck")
// .usernameParameter("email")
// .passwordParameter("password")
// .defaultSuccessUrl("/")
// .permitAll()
// .and().logout()
// .logoutUrl("/logout")
// .logoutSuccessUrl("/login")
// .permitAll()
// .and().csrf()
// .disable();
// }
// }
